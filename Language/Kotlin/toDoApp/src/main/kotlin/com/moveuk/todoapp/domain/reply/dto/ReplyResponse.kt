package com.moveuk.todoapp.domain.reply.dto

data class ReplyResponse(
    val id: Long,
    val content: String,
    val author: String,
)

