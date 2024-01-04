package com.moveuk.todoapp.domain.todo.service

import com.moveuk.todoapp.domain.exception.AuthorizationException
import com.moveuk.todoapp.domain.exception.ModelNotFoundException
import com.moveuk.todoapp.domain.todo.dto.todo.*
import com.moveuk.todoapp.domain.todo.model.Todo
import com.moveuk.todoapp.domain.todo.model.toResponse
import com.moveuk.todoapp.domain.todo.repository.TodoRepository
import com.moveuk.todoapp.domain.user.model.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TodoServiceImpl(
    private val todoRepository: TodoRepository
) : TodoService {
    override fun getAllTodos(
        sortProperty: SortProperty?,
        sortOrder: SortOrder?,
        author: String?,
        pageNumber: Int?
    ): Page<TodoResponse> {
        //Pageable 객체
        val pageable = PageRequest.of(pageNumber ?: 0, 10)
        // 할 일 카드 목록 조회
        val response: Page<TodoResponse> =
            // sort X, filter X
            if (sortProperty == null && author == null) todoRepository.findAll(pageable).map { it.toResponse() }
            // sort X, filter O
            else if (sortProperty == null && author != null) todoRepository.findAllByAuthor(author, pageable)
                .map { it.toResponse() }
            else if (author == null) {
                // sort O, filter X
                if (sortOrder == SortOrder.ASC) todoRepository.findAllByOrderByCreatedDateAsc(pageable)
                    .map { it.toResponse() }
                else todoRepository.findAllByOrderByCreatedDateDesc(pageable).map { it.toResponse() }
            } else {
                // sort O, filter O
                if (sortOrder == SortOrder.ASC) todoRepository.findAllByAuthorOrderByCreatedDateAsc(author, pageable)
                    .map { it.toResponse() }
                else todoRepository.findAllByAuthorOrderByCreatedDateDesc(author, pageable).map { it.toResponse() }
            }
        return response
    }

    override fun getTodoByID(todoId: Long): TodoResponse {
        // 할 일 카드 id기반으로 조회 후 존재시 Response dto 객체로 변환 후 반환
        // 조회시 해당 카드가 없을시 throw ModelNotFoundException
        return todoRepository.findByIdOrNull(todoId)?.toResponse() ?: throw ModelNotFoundException("Todo", todoId)
    }

    @Transactional
    override fun createTodo(request: CreateTodoRequest, authenticatedUser: User): TodoResponse {
        // request를 할 일 카드로 변환 후 저장
        // 세션에서 받아온 authenticatedUser를 author에 담아 todocard 생성
        // 저장 성공 후 저장된 객체 dto로 변환하여 반환
        return todoRepository.save(
            Todo(
                title = request.title,
                description = request.description,
                author = authenticatedUser
            )
        ).toResponse()
    }

    @Transactional
    override fun updateTodo(todoId: Long, request: UpdateTodoRequest, authenticatedUser: User): TodoResponse {
        // request를 할 일 카드로 변환 후 수정
        // 수정을 위해 조회시 해당 카드가 없을시 throw ModelNotFoundException
        // 수정 성공 후 저장된 객체 dto로 변환하여 반환
        val todo: Todo =
            todoRepository.findByIdOrNull(todoId) ?: throw ModelNotFoundException("Todo", todoId)

        if (todo.author.id != authenticatedUser.id) throw AuthorizationException("수정 권한이 없습니다.")

        val (title, description) = request

        todo.title = title
        todo.description = description

        return todoRepository.save(todo).toResponse()
    }

    @Transactional
    override fun deleteTodo(todoId: Long, authenticatedUser: User) {
        // 삭제를 위해 조회시 해당 카드가 없을시 throw ModelNotFoundException
        // DB에서 todoId 해당하는 할 일 카드 삭제 후, 연관된 Reply도 모두 삭제
        val todo: Todo =
            todoRepository.findByIdOrNull(todoId) ?: throw ModelNotFoundException("Todo", todoId)
        if (todo.author.id != authenticatedUser.id) throw AuthorizationException("삭제 권한이 없습니다.")
        todoRepository.delete(todo)
    }

    @Transactional
    override fun changeCompletionState(todoId: Long, completionState: Boolean): TodoResponse {
        // 완료 상태 수정을 위해 조회시 해당 카드가 없을시 throw ModelNotFoundException
        // 수정 성공 후 저장된 객체 dto로 변환하여 반환
        val todo: Todo =
            todoRepository.findByIdOrNull(todoId) ?: throw ModelNotFoundException("Todo", todoId)

        todo.completion = completionState

        return todoRepository.save(todo).toResponse()
    }

}
