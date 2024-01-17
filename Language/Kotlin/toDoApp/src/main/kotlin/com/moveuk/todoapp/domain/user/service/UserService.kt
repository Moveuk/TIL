package com.moveuk.todoapp.domain.user.service

import com.moveuk.todoapp.domain.exception.BadCredentialsException
import com.moveuk.todoapp.domain.exception.DuplicatedPropertyException
import com.moveuk.todoapp.domain.exception.EmailNotFoundException
import com.moveuk.todoapp.domain.todocard.repository.UserRepository
import com.moveuk.todoapp.domain.user.dto.JoinRequest
import com.moveuk.todoapp.domain.user.dto.LoginRequest
import com.moveuk.todoapp.domain.user.dto.LoginResponse
import com.moveuk.todoapp.domain.user.model.Profile
import com.moveuk.todoapp.domain.user.model.User
import com.moveuk.todoapp.infra.security.jwt.JwtPlugin
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtPlugin: JwtPlugin
) {
    @Transactional
    fun join(joinRequest: JoinRequest): String {
        // 회원가입시 이메일 중복 체크 후 유저 정보 DB 저장
        val (email, password, nickname, role) = joinRequest

        //이메일 중복 체크
        if (userRepository.existsUserByEmail(email)) throw DuplicatedPropertyException("이메일", email)

        userRepository.save(
            User(
                email = email,
                password = passwordEncoder.encode(password),
                profile = Profile(nickname = nickname),
                role = role
            )
        )
        return "회원가입 성공"
    }

    fun login(loginRequest: LoginRequest): LoginResponse {
        // 해당 이메일이 DB에 없을시 throw EmailNotFoundException
        // 비밀번호가 일치하지 않을시 throw BadCredentialsException

        // 이메일 존재하지 않을시 exception throw
        val user =
            userRepository.findUserByEmail(loginRequest.email) ?: throw EmailNotFoundException(loginRequest.email)
        // 역할, 비밀번호 일치하지 않을시
        if (user.role != loginRequest.role || !passwordEncoder.matches(
                loginRequest.password,
                user.password
            )
        ) throw BadCredentialsException()

        return LoginResponse(
            accessToken = jwtPlugin.generateAccessToken(
                subject = user.id.toString(),
                email = user.email,
                role = user.role.name
            )
        )
    }
}
