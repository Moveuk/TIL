package com.moveuk.todoapp.domain.todocard.service

import com.moveuk.todoapp.domain.todocard.dto.*
import org.springframework.data.domain.Page

interface ToDoCardService {
    fun getAllToDoCardList(sortProperty: SortProperty?, sortOrder: SortOrder?, author: String?, pageNumber: Int?): Page<ToDoCardResponse>

    fun getToDoCardByID(toDoCardId: Long): ToDoCardResponse

    fun createToDoCard(request: CreateToDoCardRequest): ToDoCardResponse

    fun updateToDoCard(toDoCardId: Long, request: UpdateToDoCardRequest): ToDoCardResponse

    fun deleteToDoCard(toDoCardId: Long)

    fun changeCompletionState(toDoCardId: Long, completionState: Boolean): ToDoCardResponse
}
