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
import com.moveuk.todoapp.domain.user.model.User
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ReplyServiceImpl(
    private val todoRepository: TodoRepository,
    private val replyRepository: ReplyRepository
) : ReplyService {
    @Transactional
    override fun createReply(todoId: Long, request: CreateReplyRequest, authenticatedUser: User): ReplyResponse {
        // request를 댓글로 변환 후 저장
        // 세션에서 받아온 authenticatedUser를 author에 담아 reply 생성
        // 저장 성공 후 저장된 객체 dto로 변환하여 반환
        val todo = todoRepository.findByIdOrNull(todoId) ?: throw ModelNotFoundException("ToDoCard", todoId)
        return replyRepository.save(
            Reply(
                todo = todo,
                content = request.content,
                password = request.password,
                author = authenticatedUser,
            )
        ).toResponse()
    }

    @Transactional
    override fun updateReply(replyId: Long, request: UpdateReplyRequest, authenticatedUser: User): ReplyResponse {
        // 수정을 위해 조회시 해당 댓글이 없을시 throw ModelNotFoundException
        // session 정보와 reply의 userId 불일치시 권한 없음으로 throw AuthorizationException
        // password 불일치시 throw WrongPasswordException
        // 수정 성공 후 저장된 객체 dto로 변환하여 반환
        val (content, password) = request
        // 존재여부 체크
        val reply =
            replyRepository.findByIdOrNull(replyId) ?: throw ModelNotFoundException("Reply", replyId)
        if (reply.author.id != authenticatedUser.id) throw AuthorizationException("수정 권한이 없습니다.")
        if (password != reply.password) throw WrongPasswordException("Reply", replyId)

        reply.content = content

        return replyRepository.save(reply).toResponse()
    }

    @Transactional
    override fun deleteReply(replyId: Long, request: DeleteReplyRequest, authenticatedUser: User) {
        // 삭제를 위해 조회시 해당 댓글이 없을시 throw ModelNotFoundException
        // session 정보와 reply의 userId 불일치시 권한 없음으로 throw AuthorizationException
        // password 불일치시 throw WrongPasswordException
        val password = request.password
        // 존재여부 체크
        val reply =
            replyRepository.findByIdOrNull(replyId) ?: throw ModelNotFoundException("Reply", replyId)
        if (reply.author.id != authenticatedUser.id) throw AuthorizationException("수정 권한이 없습니다.")
        if (password != reply.password) throw WrongPasswordException("Reply", replyId)

        replyRepository.delete(reply)
    }

}
