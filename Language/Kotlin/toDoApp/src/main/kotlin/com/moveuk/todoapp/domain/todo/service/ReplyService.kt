package com.moveuk.todoapp.domain.todo.service

import com.moveuk.todoapp.domain.exception.AuthorizationException
import com.moveuk.todoapp.domain.exception.ModelNotFoundException
import com.moveuk.todoapp.domain.exception.WrongPasswordException
import com.moveuk.todoapp.domain.todo.dto.reply.CreateReplyRequest
import com.moveuk.todoapp.domain.todo.dto.reply.DeleteReplyRequest
import com.moveuk.todoapp.domain.todo.dto.reply.ReplyResponse
import com.moveuk.todoapp.domain.todo.dto.reply.UpdateReplyRequest
import com.moveuk.todoapp.domain.todo.model.Reply
import com.moveuk.todoapp.domain.todo.model.toResponse
import com.moveuk.todoapp.domain.todo.repository.ReplyRepository
import com.moveuk.todoapp.domain.todo.repository.TodoRepository
import com.moveuk.todoapp.infra.security.UserPrincipal
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ReplyService(
    private val todoRepository: TodoRepository,
    private val replyRepository: ReplyRepository
) {
    @Transactional
    fun createReply(todoId: Long, request: CreateReplyRequest, principal: UserPrincipal): ReplyResponse {
        val todo = todoRepository.findByIdOrNull(todoId) ?: throw ModelNotFoundException("ToDoCard", todoId)
        return replyRepository.save(
            Reply(
                todo = todo,
                content = request.content,
                password = request.password,
                author = todo.author,
            )
        ).toResponse()
    }

    @Transactional
    fun updateReply(replyId: Long, request: UpdateReplyRequest, principal: UserPrincipal): ReplyResponse {
        val (content, password) = request
        // 존재여부 체크
        val reply =
            replyRepository.findByIdOrNull(replyId) ?: throw ModelNotFoundException("Reply", replyId)
        if (reply.author.id != reply.author.id) throw AuthorizationException("수정 권한이 없습니다.")
        if (password != reply.password) throw WrongPasswordException("Reply", replyId)

        reply.content = content

        return replyRepository.save(reply).toResponse()
    }

    @Transactional
    fun deleteReply(replyId: Long, request: DeleteReplyRequest, principal: UserPrincipal) {
        val password = request.password
        val reply =
            replyRepository.findByIdOrNull(replyId) ?: throw ModelNotFoundException("Reply", replyId)
        if (reply.author.id != principal.id) throw AuthorizationException("수정 권한이 없습니다.")
        if (password != reply.password) throw WrongPasswordException("Reply", replyId)

        replyRepository.delete(reply)
    }

}
