package com.moveuk.todoapp.domain.todocard.dto

data class CreateToDoCardRequest(
    val title: String,
    val description: String?,
    val author: String,
)