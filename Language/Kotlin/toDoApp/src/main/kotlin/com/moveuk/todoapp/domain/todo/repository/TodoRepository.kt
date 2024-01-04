package com.moveuk.todoapp.domain.todo.repository

import com.moveuk.todoapp.domain.todo.model.Todo
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository : JpaRepository<Todo, Long> {

    fun findAllByAuthor(author: String, pageable: Pageable) : Page<Todo>

    fun findAllByOrderByCreatedDateDesc(pageable: Pageable) : Page<Todo>

    fun findAllByOrderByCreatedDateAsc(pageable: Pageable): Page<Todo>

    fun findAllByAuthorOrderByCreatedDateDesc(author: String, pageable: Pageable) : Page<Todo>

    fun findAllByAuthorOrderByCreatedDateAsc(author: String, pageable: Pageable) : Page<Todo>

}