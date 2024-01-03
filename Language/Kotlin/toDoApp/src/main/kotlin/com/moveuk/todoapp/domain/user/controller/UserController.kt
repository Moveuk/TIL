package com.moveuk.todoapp.domain.user.controller

import com.moveuk.todoapp.domain.user.dto.JoinRequest
import com.moveuk.todoapp.domain.user.dto.LoginRequest
import com.moveuk.todoapp.domain.user.dto.UserResponse
import com.moveuk.todoapp.domain.user.model.toResponse
import com.moveuk.todoapp.domain.user.service.AuthService
import com.moveuk.todoapp.domain.user.service.UserService
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@Validated
@RestController
class UserController(
    private val userService: UserService,
    private val authService: AuthService
) {

    @PostMapping("/join")
    fun join(@Valid @RequestBody joinRequest: JoinRequest): ResponseEntity<String> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(userService.join(joinRequest))
    }

    @PostMapping("/login")
    fun login(
        @Valid @RequestBody loginRequest: LoginRequest,
        request: HttpServletRequest,
        response: HttpServletResponse
    ): ResponseEntity<UserResponse> {
        //로그인 인증 절차
        //1. 로그인 인증 - 유저 존재 확인, 유저 비밀번호 일치 확인
        //2. 세션 추가 - 세션 존재하면 반환, 세션 없으면 새로 만든 후 세션 저장
        //3. 로그인 후 유저 정보(패스워드 뺀) 반환
        val userResponse: UserResponse
        authService.authenticate(loginRequest).let {
            authService.validateSession(it, request)
            userResponse = it.toResponse()
        }
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(userResponse)
    }


    @PostMapping("/logout")
    fun logout(request: HttpServletRequest): ResponseEntity<String> {
        //로그아웃 세션 초기화

        //세션이 있으면 기존 세션을 반환한다.
        //세션이 없으면 새로운 세션을 생성하지 않는다. null 을 반환한다.
        authService.invalidateSession(request) //세션 있으면 제거

        return ResponseEntity
            .status(HttpStatus.OK)
            .body("로그아웃 성공")
    }

}