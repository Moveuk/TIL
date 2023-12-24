package com.moveuk.todoapp.domain.reply.service

import com.moveuk.todoapp.domain.reply.dto.CreateReplyRequest
import com.moveuk.todoapp.domain.reply.dto.DeleteReplyRequest
import com.moveuk.todoapp.domain.reply.dto.ReplyResponse
import com.moveuk.todoapp.domain.reply.dto.UpdateReplyRequest

interface ReplyService {
    fun createReply(toDoCardId: Long, request: CreateReplyRequest): ReplyResponse

    fun updateReply(replyId: Long, request: UpdateReplyRequest): ReplyResponse

    fun deleteReply(replyId: Long, request: DeleteReplyRequest)
}
