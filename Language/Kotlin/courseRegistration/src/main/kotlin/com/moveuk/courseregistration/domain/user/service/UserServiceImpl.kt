package com.moveuk.courseregistration.domain.user.service

import com.moveuk.courseregistration.domain.exception.InvalidCredentialException
import com.moveuk.courseregistration.domain.exception.ModelNotFoundException
import com.moveuk.courseregistration.domain.user.dto.*
import com.moveuk.courseregistration.domain.user.model.Profile
import com.moveuk.courseregistration.domain.user.model.User
import com.moveuk.courseregistration.domain.user.model.UserRole
import com.moveuk.courseregistration.domain.user.model.toResponse
import com.moveuk.courseregistration.domain.user.repository.UserRepository
import com.moveuk.courseregistration.infra.security.jwt.JwtPlugin
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val bCryptPasswordEncoder: PasswordEncoder,
    private val jwtPlugin: JwtPlugin
) : UserService {

    override fun login(loginRequest: LoginRequest): LoginResponse {
        val user = userRepository.findByEmail(loginRequest.email) ?: throw ModelNotFoundException("User", null)

        if (user.role.name != loginRequest.role || !bCryptPasswordEncoder.matches(loginRequest.password, user.password)) {
            throw InvalidCredentialException()
        }

        return LoginResponse(
            accessToken = jwtPlugin.generateAccessToken(
                subject = user.id.toString(),
                email = loginRequest.email,
                role = loginRequest.role)
        )
    }

    @Transactional
    override fun signUp(request: SignUpRequest): UserResponse {
        // TODO: Email이 중복되는지 확인, 중복된다면 throw IllegalStateException
        // TODO: request를 User로 변환 후 DB에 저장, 비밀번호는 저장시 암호화
        if (userRepository.existsByEmail(request.email)) {
            throw IllegalStateException("Email is already in use")
        }

        return userRepository.save(
            User(
                email = request.email,
                password = bCryptPasswordEncoder.encode(request.password),
                profile = Profile(
                    nickname = request.nickname
                ),
                role = when (request.role) {
                    UserRole.STUDENT.name -> UserRole.STUDENT
                    UserRole.TUTOR.name -> UserRole.TUTOR
                    else -> throw IllegalArgumentException("Invalid role")
                }
            )
        ).toResponse()
    }

    @Transactional
    override fun updateUserProfile(userId: Long, request: UpdateUserProfileRequest): UserResponse {
        // TODO: 만약 userId에 해당하는 User가 없다면 throw ModelNotFoundException
        // TODO: DB에서 userId에 해당하는 User를 가져와서 updateUserProfileRequest로 업데이트 후 DB에 저장, 결과를 UserResponse로 변환 후 반환
        val user = userRepository.findByIdOrNull(userId) ?: throw ModelNotFoundException("User", userId)
        user.profile = Profile(
            nickname = request.nickname
        )

        return userRepository.save(user).toResponse()
    }
}
