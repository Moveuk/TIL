package com.moveuk.todoapp.domain.todo.controller

import com.moveuk.todoapp.domain.todo.dto.reply.CreateReplyRequest
import com.moveuk.todoapp.domain.todo.dto.reply.DeleteReplyRequest
import com.moveuk.todoapp.domain.todo.dto.reply.ReplyResponse
import com.moveuk.todoapp.domain.todo.dto.reply.UpdateReplyRequest
import com.moveuk.todoapp.domain.todo.service.ReplyService
import jakarta.websocket.server.PathParam
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/todos/{todoId}/replies")
@RestController
class ReplyController(
    private val replyService: ReplyService
) {
    @PostMapping
    fun createReply(
        @PathVariable todoId: Long, @RequestBody createReplyRequest: CreateReplyRequest
    ): ResponseEntity<ReplyResponse> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(replyService.createReply(todoId, createReplyRequest))
    }

    @PutMapping
    fun updateReply(
        @PathParam("replyId") replyId: Long,
        @RequestBody updateReplyRequest: UpdateReplyRequest
    ): ResponseEntity<ReplyResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(replyService.updateReply(replyId, updateReplyRequest))
    }

    @DeleteMapping
    fun deleteReply(@PathParam("replyId") replyId: Long, deleteReplyRequest: DeleteReplyRequest): ResponseEntity<Unit> {
        replyService.deleteReply(replyId, deleteReplyRequest)
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .build()
    }

}