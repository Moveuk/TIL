package com.moveuk.todoapp.domain.user.service

import com.moveuk.todoapp.domain.exception.DuplicatedPropertyException
import com.moveuk.todoapp.domain.todocard.repository.UserRepository
import com.moveuk.todoapp.domain.user.dto.JoinRequest
import com.moveuk.todoapp.domain.user.model.Profile
import com.moveuk.todoapp.domain.user.model.User
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    val userRepository: UserRepository
) : UserService {
    override fun join(joinRequest: JoinRequest): String {
        // 회원가입시 이메일 중복 체크 후 유저 정보 DB 저장
        val email = joinRequest.email

        //이메일 중복 체크
        if (userRepository.existsUserByEmail(email)) throw DuplicatedPropertyException("이메일", email)

        userRepository.save(User(email = email, password = joinRequest.password, profile = Profile(nickname = joinRequest.nickname)))
        return "회원가입 성공"
    }
}
