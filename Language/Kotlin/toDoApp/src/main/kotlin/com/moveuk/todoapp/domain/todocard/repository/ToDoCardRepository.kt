package com.moveuk.todoapp.domain.todocard.repository

import com.moveuk.todoapp.domain.todocard.model.ToDoCard
import org.springframework.data.jpa.repository.JpaRepository

interface ToDoCardRepository : JpaRepository<ToDoCard, Long> {

}
