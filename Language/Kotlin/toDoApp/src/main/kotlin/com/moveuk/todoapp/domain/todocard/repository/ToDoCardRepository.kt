package com.moveuk.todoapp.domain.todocard.repository

import com.moveuk.todoapp.domain.todocard.model.ToDoCard
import org.springframework.data.jpa.repository.JpaRepository

interface ToDoCardRepository : JpaRepository<ToDoCard, Long> {

    fun findAllByAuthor(author: String) : MutableList<ToDoCard>

    fun findAllByOrderByCreatedDateDesc() : MutableList<ToDoCard>

    fun findAllByOrderByCreatedDateAsc(): MutableList<ToDoCard>

    fun findAllByAuthorOrderByCreatedDateDesc(author: String) : MutableList<ToDoCard>

    fun findAllByAuthorOrderByCreatedDateAsc(author: String) : MutableList<ToDoCard>

}
