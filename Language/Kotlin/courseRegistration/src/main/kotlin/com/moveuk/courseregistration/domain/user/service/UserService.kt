package com.moveuk.courseregistration.domain.user.service

import com.moveuk.courseregistration.domain.user.dto.*

interface UserService {

    fun signUp(signUpRequest: SignUpRequest): UserResponse

    fun updateUserProfile(userId: Long, updateUserProfileRequest: UpdateUserProfileRequest): UserResponse

    fun login(loginRequest: LoginRequest): LoginResponse
}