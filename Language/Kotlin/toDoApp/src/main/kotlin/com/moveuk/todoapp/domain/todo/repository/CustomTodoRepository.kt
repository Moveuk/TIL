package com.moveuk.todoapp.domain.todo.repository

import com.moveuk.todoapp.domain.todo.model.Todo
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface CustomTodoRepository {
    fun findAllByPageableAndNickname(pageable: Pageable, nickname: String?): Page<Todo>?
}