package com.moveuk.todoapp.domain.todo.controller

import com.moveuk.todoapp.domain.todo.dto.reply.CreateReplyRequest
import com.moveuk.todoapp.domain.todo.dto.reply.DeleteReplyRequest
import com.moveuk.todoapp.domain.todo.dto.reply.ReplyResponse
import com.moveuk.todoapp.domain.todo.dto.reply.UpdateReplyRequest
import com.moveuk.todoapp.domain.todo.service.ReplyService
import com.moveuk.todoapp.domain.user.service.AuthService
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/todos/{todoId}/replies")
@RestController
class ReplyController(
    private val replyService: ReplyService,
    private val authService: AuthService
) {
    @PostMapping
    fun createReply(
        @PathVariable todoId: Long,
        @RequestBody createReplyRequest: CreateReplyRequest,
        request: HttpServletRequest
    ): ResponseEntity<ReplyResponse> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(
                authService.checkAuthenticatedUser(request).let {//세션에서 로그인 상태 확인 후 user 정보 반환
                    replyService.createReply(todoId, createReplyRequest, it)
                }
            )
    }

    @PutMapping("/{replyId}")
    fun updateReply(
        @PathVariable replyId: Long,
        @RequestBody updateReplyRequest: UpdateReplyRequest,
        request: HttpServletRequest
    ): ResponseEntity<ReplyResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(
                authService.checkAuthenticatedUser(request).let {
                    replyService.updateReply(replyId, updateReplyRequest, it)
                }
            )
    }

    @DeleteMapping("/{replyId}")
    fun deleteReply(
        @PathVariable replyId: Long,
        deleteReplyRequest: DeleteReplyRequest,
        request: HttpServletRequest
    ): ResponseEntity<Unit> {
        authService.checkAuthenticatedUser(request).let {
            replyService.deleteReply(replyId, deleteReplyRequest, it)
        }
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .build()
    }

}