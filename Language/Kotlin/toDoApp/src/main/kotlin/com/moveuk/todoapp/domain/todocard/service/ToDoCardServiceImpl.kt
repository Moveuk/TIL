package com.moveuk.todoapp.domain.todocard.service

import com.moveuk.todoapp.domain.exception.ModelNotFoundException
import com.moveuk.todoapp.domain.todocard.dto.CreateToDoCardRequest
import com.moveuk.todoapp.domain.todocard.dto.ToDoCardResponse
import com.moveuk.todoapp.domain.todocard.dto.UpdateToDoCardRequest
import com.moveuk.todoapp.domain.todocard.model.ToDoCard
import com.moveuk.todoapp.domain.todocard.model.toResponse
import com.moveuk.todoapp.domain.todocard.repository.ToDoCardRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ToDoCardServiceImpl(
    private val toDoCardRepository: ToDoCardRepository
) : ToDoCardService {
    override fun getAllToDoCardList(): List<ToDoCardResponse> {
        // 할 일 카드 목록 조회
        return toDoCardRepository.findAll().map { it.toResponse() }
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
//                user = findByIdOrNullUser
            )
        ).toResponse()
    }

    override fun updateToDoCard(toDoCardId: Long, request: UpdateToDoCardRequest): ToDoCardResponse {
        // request를 할 일 카드로 변환 후 수정
        // 수정을 위해 조회시 해당 카드가 없을시 throw ModelNotFoundException
        // 수정 성공 후 저장된 객체 dto로 변환하여 반환
        val toDoCard =
            toDoCardRepository.findByIdOrNull(toDoCardId) ?: throw ModelNotFoundException("ToDoCard", toDoCardId)
        val (title, description) = request

        toDoCard.title = title
        toDoCard.description = description

        return toDoCardRepository.save(toDoCard).toResponse()
    }

    override fun deleteToDoCard(toDoCardId: Long) {
        // 삭제를 위해 조회시 해당 카드가 없을시 throw ModelNotFoundException
        // TODO : DB에서 toDoCardId 해당하는 할 일 카드 삭제 후, 연관된 Reply도 모두 삭제
        val toDoCard =
            toDoCardRepository.findByIdOrNull(toDoCardId) ?: throw ModelNotFoundException("ToDoCard", toDoCardId)
        toDoCardRepository.delete(toDoCard)
    }

}
