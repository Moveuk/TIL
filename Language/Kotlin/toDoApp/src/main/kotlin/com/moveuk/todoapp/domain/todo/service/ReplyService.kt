package com.moveuk.todoapp.domain.todo.service

import com.moveuk.todoapp.domain.todo.dto.reply.CreateReplyRequest
import com.moveuk.todoapp.domain.todo.dto.reply.DeleteReplyRequest
import com.moveuk.todoapp.domain.todo.dto.reply.ReplyResponse
import com.moveuk.todoapp.domain.todo.dto.reply.UpdateReplyRequest
import com.moveuk.todoapp.domain.user.model.User

interface ReplyService {
    fun createReply(todoId: Long, request: CreateReplyRequest, authenticatedUser: User): ReplyResponse

    fun updateReply(replyId: Long, request: UpdateReplyRequest): ReplyResponse

    fun deleteReply(replyId: Long, request: DeleteReplyRequest)
}
