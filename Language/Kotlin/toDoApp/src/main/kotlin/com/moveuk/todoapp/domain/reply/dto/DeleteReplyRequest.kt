package com.moveuk.todoapp.domain.reply.dto

data class DeleteReplyRequest(
    val password: String,
    val author: String,
)