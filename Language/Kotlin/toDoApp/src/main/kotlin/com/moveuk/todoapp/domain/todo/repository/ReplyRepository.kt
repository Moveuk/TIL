package com.moveuk.todoapp.domain.todo.repository

import com.moveuk.todoapp.domain.todo.model.Reply
import org.springframework.data.jpa.repository.JpaRepository

interface ReplyRepository : JpaRepository<Reply, Long> {

}
