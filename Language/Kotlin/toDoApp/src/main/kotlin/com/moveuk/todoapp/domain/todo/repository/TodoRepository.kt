package com.moveuk.todoapp.domain.todo.repository

import com.moveuk.todoapp.domain.todo.model.Todo
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TodoRepository : JpaRepository<Todo, Long> {

    @Query("SELECT t FROM Todo t join fetch t.author where t.author.profile.nickname = :author")
    fun findAllByAuthor(author: String, pageable: Pageable) : Page<Todo>

    fun findAllByOrderByCreatedDateDesc(pageable: Pageable) : Page<Todo>

    fun findAllByOrderByCreatedDateAsc(pageable: Pageable): Page<Todo>

    @Query("SELECT t FROM Todo t join fetch t.author where t.author.profile.nickname = :author order by t.createdDate desc")
    fun findAllByAuthorOrderByCreatedDateDesc(author: String, pageable: Pageable) : Page<Todo>

    @Query("SELECT t FROM Todo t join fetch t.author where t.author.profile.nickname = :author order by t.createdDate asc")
    fun findAllByAuthorOrderByCreatedDateAsc(author: String, pageable: Pageable) : Page<Todo>

}
