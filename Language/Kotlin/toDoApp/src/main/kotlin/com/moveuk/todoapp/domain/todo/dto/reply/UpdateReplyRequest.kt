package com.moveuk.todoapp.domain.todo.dto.reply

data class UpdateReplyRequest(
    val content: String,
    val password: String,
    val author: String,
)
