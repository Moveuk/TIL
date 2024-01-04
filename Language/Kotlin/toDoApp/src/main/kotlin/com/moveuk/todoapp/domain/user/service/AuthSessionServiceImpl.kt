package com.moveuk.todoapp.domain.user.service

import com.moveuk.todoapp.domain.exception.AuthenticationException
import com.moveuk.todoapp.domain.exception.BadCredentialsException
import com.moveuk.todoapp.domain.exception.EmailNotFoundException
import com.moveuk.todoapp.domain.todocard.repository.UserRepository
import com.moveuk.todoapp.domain.user.dto.LoginRequest
import com.moveuk.todoapp.domain.user.model.User
import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Service

@Service
class AuthSessionServiceImpl(
    val userRepository: UserRepository
) : AuthService {
    override fun authenticate(loginRequest: LoginRequest): User {
        // 해당 이메일이 DB에 없을시 throw EmailNotFoundException
        // 비밀번호가 일치하지 않을시 throw BadCredentialsException

        // 이메일 존재하지 않을시 exception throw
        val user =
            userRepository.findUserByEmail(loginRequest.email) ?: throw EmailNotFoundException(loginRequest.email)
        // 비밀번호 일치하지 않을시
        if (user.password != loginRequest.password) throw BadCredentialsException()

        return user
    }

    override fun validateSession(authenticatedUser: User, request: HttpServletRequest) {
        //세션 추가
        //세션이 있으면 있는 세션반환 , 없으면 신규 세션을 생성
        val session = request.session
        //세션에 로그인 회원 정보 보관
        session.setAttribute("loginUser", authenticatedUser)
    }

    override fun invalidateSession(request: HttpServletRequest) {
        //false 옵션 - 세션이 있으면 있는 세션반환 , 없으면 null 반환
        request.getSession(false)?.invalidate()
    }

    override fun checkAuthenticatedUser(request: HttpServletRequest): User {
        //저장된 세션이 없으면 로그인 필요
        val session = request.getSession(false) ?: throw AuthenticationException("로그인을 먼저 진행해 주세요.")

        return session.getAttribute("loginUser") as User
    }
}
