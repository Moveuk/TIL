package com.moveuk.todoapp.domain.user.dto

import com.moveuk.todoapp.domain.user.model.Profile
import com.moveuk.todoapp.domain.user.model.UserRole

data class UserResponse(
    val id: Long,
    val email: String,
    val profile: Profile,
    val role: UserRole,
)
