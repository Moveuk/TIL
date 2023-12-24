package com.moveuk.todoapp.domain.reply.controller

import com.moveuk.todoapp.domain.reply.dto.CreateReplyRequest
import com.moveuk.todoapp.domain.reply.dto.DeleteReplyRequest
import com.moveuk.todoapp.domain.reply.dto.ReplyResponse
import com.moveuk.todoapp.domain.reply.dto.UpdateReplyRequest
import com.moveuk.todoapp.domain.reply.service.ReplyService
import jakarta.websocket.server.PathParam
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/to-do-cards/{toDoCardId}/replies")
@RestController
class ReplyController(
    private val replyService: ReplyService
) {
    @PostMapping
    fun createReply(
        @PathVariable toDoCardId: Long, @RequestBody createReplyRequest: CreateReplyRequest
    ): ResponseEntity<ReplyResponse> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(replyService.createReply(toDoCardId, createReplyRequest))
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