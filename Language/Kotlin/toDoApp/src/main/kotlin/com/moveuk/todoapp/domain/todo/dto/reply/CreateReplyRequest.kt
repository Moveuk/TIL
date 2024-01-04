package com.moveuk.todoapp.domain.todo.dto.reply

data class CreateReplyRequest(
    val content: String,
    val password: String
)
