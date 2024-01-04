package com.moveuk.todoapp.domain.todo.service

import com.moveuk.todoapp.domain.todo.dto.todo.*
import org.springframework.data.domain.Page

interface TodoService {
    fun getAllTodos(sortProperty: SortProperty?, sortOrder: SortOrder?, author: String?, pageNumber: Int?): Page<TodoResponse>

    fun getTodoByID(todoId: Long): TodoResponse

    fun createTodo(request: CreateTodoRequest): TodoResponse

    fun updateTodo(todoId: Long, request: UpdateTodoRequest): TodoResponse

    fun deleteTodo(todoId: Long)

    fun changeCompletionState(todoId: Long, completionState: Boolean): TodoResponse
}