package com.moveuk.courseregistration.domain.user.service

import com.moveuk.courseregistration.domain.user.dto.SignUpRequest
import com.moveuk.courseregistration.domain.user.dto.UpdateUserProfileRequest
import com.moveuk.courseregistration.domain.user.dto.UserResponse

interface UserService {

    fun signUp(signUpRequest: SignUpRequest): UserResponse

    fun updateUserProfile(userId: Long, updateUserProfileRequest: UpdateUserProfileRequest): UserResponse
}