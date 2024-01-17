package com.moveuk.todoapp.domain.user.service

import com.moveuk.todoapp.domain.exception.DuplicatedPropertyException
import com.moveuk.todoapp.domain.todocard.repository.UserRepository
import com.moveuk.todoapp.domain.user.dto.JoinRequest
import com.moveuk.todoapp.domain.user.model.Profile
import com.moveuk.todoapp.domain.user.model.User
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) : UserService {
    @Transactional
    override fun join(joinRequest: JoinRequest): String {
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
            ))
        return "회원가입 성공"
    }
}
