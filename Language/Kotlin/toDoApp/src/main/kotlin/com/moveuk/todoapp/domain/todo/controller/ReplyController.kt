package com.moveuk.todoapp.domain.todo.controller

import com.moveuk.todoapp.domain.todo.dto.reply.CreateReplyRequest
import com.moveuk.todoapp.domain.todo.dto.reply.DeleteReplyRequest
import com.moveuk.todoapp.domain.todo.dto.reply.ReplyResponse
import com.moveuk.todoapp.domain.todo.dto.reply.UpdateReplyRequest
import com.moveuk.todoapp.domain.todo.service.ReplyService
import com.moveuk.todoapp.infra.security.UserPrincipal
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*

@RequestMapping("/todos/{todoId}/replies")
@RestController
class ReplyController(
    private val replyService: ReplyService
) {
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @PostMapping
    fun createReply(
        @PathVariable todoId: Long,
        @RequestBody createReplyRequest: CreateReplyRequest,
        request: HttpServletRequest
    ): ResponseEntity<ReplyResponse> {
        return (SecurityContextHolder
            .getContext()
            .authentication
            .principal as UserPrincipal).let { userPrincipal ->
            replyService.createReply(todoId, createReplyRequest, userPrincipal)
        }.let {
            ResponseEntity
                .status(HttpStatus.CREATED)
                .body(it)
        }
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @PutMapping("/{replyId}")
    fun updateReply(
        @PathVariable replyId: Long,
        @RequestBody updateReplyRequest: UpdateReplyRequest,
        request: HttpServletRequest
    ): ResponseEntity<ReplyResponse> {
        return (SecurityContextHolder
            .getContext()
            .authentication
            .principal as UserPrincipal).let { userPrincipal ->
            replyService.updateReply(replyId, updateReplyRequest, userPrincipal)
        }.let {
            ResponseEntity
                .status(HttpStatus.OK)
                .body(it)
        }
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @DeleteMapping("/{replyId}")
    fun deleteReply(
        @PathVariable replyId: Long,
        deleteReplyRequest: DeleteReplyRequest,
        request: HttpServletRequest
    ): ResponseEntity<Unit> {
        return (SecurityContextHolder
            .getContext()
            .authentication
            .principal as UserPrincipal).let { userPrincipal ->
            replyService.deleteReply(replyId, deleteReplyRequest, userPrincipal)
        }.let {
            ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(it)
        }
    }

}