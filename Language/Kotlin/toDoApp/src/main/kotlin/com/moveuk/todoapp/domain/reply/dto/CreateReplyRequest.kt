package com.moveuk.todoapp.domain.reply.dto

data class CreateReplyRequest(
    val content: String,
    val password: String,
    val author: String,
)
