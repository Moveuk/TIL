package com.moveuk.todoapp.domain.todo.service

import com.moveuk.todoapp.domain.exception.AuthorizationException
import com.moveuk.todoapp.domain.exception.ModelNotFoundException
import com.moveuk.todoapp.domain.todo.dto.todo.*
import com.moveuk.todoapp.domain.todo.model.Todo
import com.moveuk.todoapp.domain.todo.model.toResponse
import com.moveuk.todoapp.domain.todo.repository.TodoRepository
import com.moveuk.todoapp.domain.todocard.repository.UserRepository
import com.moveuk.todoapp.infra.security.UserPrincipal
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TodoService(
    private val todoRepository: TodoRepository,
    private val userRepository: UserRepository
) {
    fun getAllTodos(
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

    fun getTodoByID(todoId: Long): TodoResponse {
        return todoRepository.findByIdOrNull(todoId)?.toResponse() ?: throw ModelNotFoundException("Todo", todoId)
    }

    @Transactional
    fun createTodo(request: CreateTodoRequest, principal: UserPrincipal): TodoResponse {
        return userRepository.findByIdOrNull(principal.id)!!.let {
            todoRepository.save(
                Todo(
                    title = request.title,
                    description = request.description,
                    author = it
                )
            ).toResponse()
        }
    }

    @Transactional
    fun updateTodo(todoId: Long, request: UpdateTodoRequest, principal: UserPrincipal): TodoResponse {
        val todo: Todo =
            todoRepository.findByIdOrNull(todoId) ?: throw ModelNotFoundException("Todo", todoId)

        if (todo.author.id != principal.id) throw AuthorizationException("수정 권한이 없습니다.")

        val (title, description) = request

        todo.title = title
        todo.description = description

        return todoRepository.save(todo).toResponse()
    }

    @Transactional
    fun deleteTodo(todoId: Long, principal: UserPrincipal) {
        val todo: Todo =
            todoRepository.findByIdOrNull(todoId) ?: throw ModelNotFoundException("Todo", todoId)
        if (todo.author.id != principal.id) throw AuthorizationException("삭제 권한이 없습니다.")
        todoRepository.delete(todo)
    }

    @Transactional
    fun changeCompletionState(todoId: Long, completionState: Boolean, principal: UserPrincipal): TodoResponse {
        val todo: Todo =
            todoRepository.findByIdOrNull(todoId) ?: throw ModelNotFoundException("Todo", todoId)

        if (todo.author.id != principal.id) throw AuthorizationException("수정 권한이 없습니다.")

        todo.completion = completionState

        return todoRepository.save(todo).toResponse()
    }

}
