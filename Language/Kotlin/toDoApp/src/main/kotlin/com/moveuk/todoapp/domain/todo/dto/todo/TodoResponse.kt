package com.moveuk.todoapp.domain.todo.dto.todo

import com.moveuk.todoapp.domain.todo.dto.reply.ReplyResponse
import com.moveuk.todoapp.domain.user.model.Profile
import java.time.LocalDateTime

data class TodoResponse(
    val id: Long,
    val title: String,
    val description: String?,
    val author: Profile,
    val completion: Boolean,
    val createdDate: LocalDateTime,
    val replies: List<ReplyResponse>,
)
