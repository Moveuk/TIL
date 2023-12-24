package com.moveuk.todoapp.domain.todocard.dto

import java.time.LocalDateTime

data class ToDoCardResponse(
    val id: Long,
    val title: String,
    val description: String?,
    val author: String,
    val completion: Boolean,
    val createdDate: LocalDateTime,
)
