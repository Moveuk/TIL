package com.moveuk.todoapp.domain.todo.service

import com.moveuk.todoapp.domain.todo.dto.todo.*
import com.moveuk.todoapp.domain.user.model.User
import org.springframework.data.domain.Page

interface TodoService {
    fun getAllTodos(
        sortProperty: SortProperty?,
        sortOrder: SortOrder?,
        author: String?,
        pageNumber: Int?
    ): Page<TodoResponse>

    fun getTodoByID(todoId: Long): TodoResponse

    fun createTodo(request: CreateTodoRequest, authenticatedUser: User): TodoResponse

    fun updateTodo(todoId: Long, request: UpdateTodoRequest, authenticatedUser: User): TodoResponse

    fun deleteTodo(todoId: Long, authenticatedUser: User)

    fun changeCompletionState(todoId: Long, completionState: Boolean): TodoResponse
}
