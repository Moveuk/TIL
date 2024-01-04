package com.moveuk.todoapp.domain.user.dto

import com.moveuk.todoapp.domain.user.model.Profile

data class UserResponse(
    val id: Long,
    val email: String,
    val profile: Profile
)
