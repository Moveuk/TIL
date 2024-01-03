package com.moveuk.todoapp.domain.user.service

import com.moveuk.todoapp.domain.user.dto.JoinRequest

interface UserService {
    fun join(joinRequest: JoinRequest): String

}
