package com.moveuk.todoapp.domain.todo.service

import com.moveuk.todoapp.domain.exception.ModelNotFoundException
import com.moveuk.todoapp.domain.exception.WrongPasswordOrAuthorException
import com.moveuk.todoapp.domain.todo.dto.reply.CreateReplyRequest
import com.moveuk.todoapp.domain.todo.dto.reply.DeleteReplyRequest
import com.moveuk.todoapp.domain.todo.dto.reply.ReplyResponse
import com.moveuk.todoapp.domain.todo.dto.reply.UpdateReplyRequest
import com.moveuk.todoapp.domain.todo.model.Reply
import com.moveuk.todoapp.domain.todo.model.toResponse
import com.moveuk.todoapp.domain.todo.repository.ReplyRepository
import com.moveuk.todoapp.domain.todo.repository.TodoRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ReplyServiceImpl(
    private val todoRepository: TodoRepository,
    private val replyRepository: ReplyRepository
) : ReplyService {
    @Transactional
    override fun createReply(todoId: Long, request: CreateReplyRequest): ReplyResponse {
        // request를 댓글로 변환 후 저장
        // TODO : 인증 기능 추가 후 유저가 없다면 회원 오류로 throw : 추후 author를 user로 대체시
        // 저장 성공 후 저장된 객체 dto로 변환하여 반환
        val todo =
            todoRepository.findByIdOrNull(todoId) ?: throw ModelNotFoundException(
                "ToDoCard",
                todoId
            )
        return replyRepository.save(
            Reply(
                todo = todo,
                content = request.content,
                password = request.password,
                author = request.author,
            )
        ).toResponse()
    }

    @Transactional
    override fun updateReply(replyId: Long, request: UpdateReplyRequest): ReplyResponse {
        // 수정을 위해 조회시 해당 댓글이 없을시 throw ModelNotFoundException
        // password, author 불일치시 throw WrongPasswordOrAuthorException
        // 수정 성공 후 저장된 객체 dto로 변환하여 반환
        val (content, password, author) = request
        // 존재여부 체크
        val reply =
            replyRepository.findByIdOrNull(replyId) ?: throw ModelNotFoundException("Reply", replyId)
        // password, author 일치 여부 체크
        if (password != reply.password || author != reply.author) throw WrongPasswordOrAuthorException("Reply", replyId)

        reply.content = content

        return replyRepository.save(reply).toResponse()
    }

    @Transactional
    override fun deleteReply(replyId: Long, request: DeleteReplyRequest) {
        // 삭제를 위해 조회시 해당 댓글이 없을시 throw ModelNotFoundException
        // password, author 불일치시 throw WrongPasswordOrAuthorException
        val (password, author) = request
        // 존재여부 체크
        val reply =
            replyRepository.findByIdOrNull(replyId) ?: throw ModelNotFoundException("Reply", replyId)
        // password, author 일치 여부 체크
        if (password != reply.password || author != reply.author) throw WrongPasswordOrAuthorException("Reply", replyId)

        replyRepository.delete(reply)
    }

}
