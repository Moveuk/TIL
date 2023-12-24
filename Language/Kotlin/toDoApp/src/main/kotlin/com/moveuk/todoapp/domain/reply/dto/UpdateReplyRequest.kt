package com.moveuk.todoapp.domain.reply.dto

data class UpdateReplyRequest(
    val content: String,
    val password: String,
    val author: String,
)
