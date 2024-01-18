package com.moveuk.todoapp.domain.todo.repository

import com.moveuk.todoapp.domain.todo.model.Todo
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository : JpaRepository<Todo, Long>, CustomTodoRepository {
}
