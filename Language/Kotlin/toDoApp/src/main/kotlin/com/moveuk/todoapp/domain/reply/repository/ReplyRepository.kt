package com.moveuk.todoapp.domain.reply.repository

import com.moveuk.todoapp.domain.reply.model.Reply
import org.springframework.data.jpa.repository.JpaRepository

interface ReplyRepository : JpaRepository<Reply, Long> {

}
