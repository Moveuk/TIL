package com.moveuk.todoapp.domain.todo.dto.reply

import com.moveuk.todoapp.domain.user.model.Profile

data class ReplyResponse(
    val id: Long,
    val content: String,
    val author: Profile,
)

