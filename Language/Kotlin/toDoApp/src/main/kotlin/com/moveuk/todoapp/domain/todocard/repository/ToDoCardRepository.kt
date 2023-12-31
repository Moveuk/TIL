package com.moveuk.todoapp.domain.todocard.repository

import com.moveuk.todoapp.domain.todocard.model.ToDoCard
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface ToDoCardRepository : JpaRepository<ToDoCard, Long> {

    fun findAllByAuthor(author: String, pageable: Pageable) : Page<ToDoCard>

    fun findAllByOrderByCreatedDateDesc(pageable: Pageable) : Page<ToDoCard>

    fun findAllByOrderByCreatedDateAsc(pageable: Pageable): Page<ToDoCard>

    fun findAllByAuthorOrderByCreatedDateDesc(author: String, pageable: Pageable) : Page<ToDoCard>

    fun findAllByAuthorOrderByCreatedDateAsc(author: String, pageable: Pageable) : Page<ToDoCard>

}
