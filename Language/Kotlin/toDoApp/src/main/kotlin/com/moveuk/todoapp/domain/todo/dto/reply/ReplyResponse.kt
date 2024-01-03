package com.moveuk.todoapp.domain.todo.dto.reply

data class ReplyResponse(
    val id: Long,
    val content: String,
    val author: String,
)

