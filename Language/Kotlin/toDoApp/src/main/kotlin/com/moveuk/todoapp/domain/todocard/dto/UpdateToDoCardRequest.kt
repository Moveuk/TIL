package com.moveuk.todoapp.domain.todocard.dto

data class UpdateToDoCardRequest(
    val title: String,
    val description: String?,
)
