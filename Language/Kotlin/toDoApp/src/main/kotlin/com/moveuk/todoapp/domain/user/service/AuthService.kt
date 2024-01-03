package com.moveuk.todoapp.domain.user.service

import com.moveuk.todoapp.domain.user.dto.LoginRequest
import com.moveuk.todoapp.domain.user.model.User
import jakarta.servlet.http.HttpServletRequest

interface AuthService {
    fun authenticate(loginRequest: LoginRequest): User
    fun validateSession(authenticatedUser: User, request: HttpServletRequest)
    fun invalidateSession(request: HttpServletRequest)
}
