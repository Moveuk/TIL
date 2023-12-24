package com.moveuk.todoapp.domain.todocard.dto

data class ToDoCardResponse(
    val id: Long,
    val title: String,
    val description: String?,
//    val user: User,
    val completion: Boolean
)
