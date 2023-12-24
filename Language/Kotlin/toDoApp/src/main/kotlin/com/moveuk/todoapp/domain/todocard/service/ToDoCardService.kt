package com.moveuk.todoapp.domain.todocard.service

import com.moveuk.todoapp.domain.todocard.dto.CreateToDoCardRequest
import com.moveuk.todoapp.domain.todocard.dto.ToDoCardResponse
import com.moveuk.todoapp.domain.todocard.dto.UpdateToDoCardRequest

interface ToDoCardService {
    fun getAllToDoCardList(): List<ToDoCardResponse>

    fun getToDoCardByID(toDoCardId: Long): ToDoCardResponse

    fun createToDoCard(request: CreateToDoCardRequest): ToDoCardResponse

    fun updateToDoCard(toDoCardId: Long, request: UpdateToDoCardRequest): ToDoCardResponse

    fun deleteToDoCard(toDoCardId: Long)
    fun changeCompletionState(toDoCardId: Long, completionState: Boolean): ToDoCardResponse
}
