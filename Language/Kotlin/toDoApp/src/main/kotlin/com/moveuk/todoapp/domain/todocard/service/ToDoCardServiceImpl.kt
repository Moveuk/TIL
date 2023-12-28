package com.moveuk.todoapp.domain.todocard.service

import com.moveuk.todoapp.domain.exception.ModelNotFoundException
import com.moveuk.todoapp.domain.todocard.dto.*
import com.moveuk.todoapp.domain.todocard.model.ToDoCard
import com.moveuk.todoapp.domain.todocard.model.toResponse
import com.moveuk.todoapp.domain.todocard.repository.ToDoCardRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class ToDoCardServiceImpl(
    private val toDoCardRepository: ToDoCardRepository
) : ToDoCardService {
    override fun getAllToDoCardList(
        sortProperty: SortProperty?,
        sortOrder: SortOrder?,
        author: String?
    ): List<ToDoCardResponse> {
        // 할 일 카드 목록 조회
        val response: List<ToDoCardResponse> =
            // sort X, filter X
            if (sortProperty == null && author == null) toDoCardRepository.findAll().map { it.toResponse() }
            // sort X, filter O
            else if (sortProperty == null && author != null) toDoCardRepository.findAllByAuthor(author)
                .map { it.toResponse() }
            else if (author == null) {
                // sort O, filter X
                if (sortOrder == SortOrder.ASC) toDoCardRepository.findAllByOrderByCreatedDateAsc()
                    .map { it.toResponse() }
                else toDoCardRepository.findAllByOrderByCreatedDateDesc().map { it.toResponse() }
            } else {
                // sort O, filter O
                if (sortOrder == SortOrder.ASC) toDoCardRepository.findAllByAuthorOrderByCreatedDateAsc(author)
                    .map { it.toResponse() }
                else toDoCardRepository.findAllByAuthorOrderByCreatedDateDesc(author).map { it.toResponse() }
            }
        return response
    }

    override fun getToDoCardByID(toDoCardId: Long): ToDoCardResponse {
        // 할 일 카드 id기반으로 조회 후 존재시 Response dto 객체로 변환 후 반환
        // 조회시 해당 카드가 없을시 throw ModelNotFoundException
        val toDoCard =
            toDoCardRepository.findByIdOrNull(toDoCardId) ?: throw ModelNotFoundException("ToDoCard", toDoCardId)
        return toDoCard.toResponse()
    }

    @Transactional
    override fun createToDoCard(request: CreateToDoCardRequest): ToDoCardResponse {
        // request를 할 일 카드로 변환 후 저장
        // TODO : 기존 유저인지 확인 후 없으면(처음 카드를 작성하는 유저일 경우) 새로운 유저 생성 후 저장
        // TODO : 인증 기능 추가 후 유저가 없다면 회원 오류로 throw
        // 저장 성공 후 저장된 객체 dto로 변환하여 반환
//        val findByIdOrNullUser = userRepository.findByIdOrNull(request.userId ?: -1L) ?: userRepository.save(User())
        return toDoCardRepository.save(
            ToDoCard(
                title = request.title,
                description = request.description,
                author = request.author,
                createdDate = LocalDateTime.now()
            )
        ).toResponse()
    }

    @Transactional
    override fun updateToDoCard(toDoCardId: Long, request: UpdateToDoCardRequest): ToDoCardResponse {
        // request를 할 일 카드로 변환 후 수정
        // 수정을 위해 조회시 해당 카드가 없을시 throw ModelNotFoundException
        // 수정 성공 후 저장된 객체 dto로 변환하여 반환
        val toDoCard =
            toDoCardRepository.findByIdOrNull(toDoCardId) ?: throw ModelNotFoundException("ToDoCard", toDoCardId)
        val (title, description, author) = request

        toDoCard.title = title
        toDoCard.description = description
        toDoCard.author = author

        return toDoCardRepository.save(toDoCard).toResponse()
    }

    @Transactional
    override fun deleteToDoCard(toDoCardId: Long) {
        // 삭제를 위해 조회시 해당 카드가 없을시 throw ModelNotFoundException
        // TODO : DB에서 toDoCardId 해당하는 할 일 카드 삭제 후, 연관된 Reply도 모두 삭제
        val toDoCard =
            toDoCardRepository.findByIdOrNull(toDoCardId) ?: throw ModelNotFoundException("ToDoCard", toDoCardId)
        toDoCardRepository.delete(toDoCard)
    }

    @Transactional
    override fun changeCompletionState(toDoCardId: Long, completionState: Boolean): ToDoCardResponse {
        // 완료 상태 수정을 위해 조회시 해당 카드가 없을시 throw ModelNotFoundException
        // 수정 성공 후 저장된 객체 dto로 변환하여 반환
        val toDoCard =
            toDoCardRepository.findByIdOrNull(toDoCardId) ?: throw ModelNotFoundException("ToDoCard", toDoCardId)

        toDoCard.completion = completionState

        return toDoCardRepository.save(toDoCard).toResponse()
    }

}
