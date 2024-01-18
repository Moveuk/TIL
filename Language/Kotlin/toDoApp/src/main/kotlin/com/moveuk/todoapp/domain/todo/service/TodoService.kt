package com.moveuk.todoapp.domain.todo.service

import com.moveuk.todoapp.domain.exception.AuthorizationException
import com.moveuk.todoapp.domain.exception.ModelNotFoundException
import com.moveuk.todoapp.domain.todo.dto.todo.CreateTodoRequest
import com.moveuk.todoapp.domain.todo.dto.todo.TodoResponse
import com.moveuk.todoapp.domain.todo.dto.todo.UpdateTodoRequest
import com.moveuk.todoapp.domain.todo.model.Todo
import com.moveuk.todoapp.domain.todo.model.toResponse
import com.moveuk.todoapp.domain.todo.repository.TodoRepository
import com.moveuk.todoapp.domain.todocard.repository.UserRepository
import com.moveuk.todoapp.infra.security.UserPrincipal
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TodoService(
    private val todoRepository: TodoRepository,
    private val userRepository: UserRepository
) {
    fun getAllTodos(
        pageable: Pageable,
        nickname: String?
    ): Page<TodoResponse>? {
        return todoRepository.findAllByPageableAndNickname(pageable, nickname)?.map { it.toResponse() }
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
                    user = it
                )
            ).toResponse()
        }
    }

    @Transactional
    fun updateTodo(todoId: Long, request: UpdateTodoRequest, principal: UserPrincipal): TodoResponse {
        val todo: Todo =
            todoRepository.findByIdOrNull(todoId) ?: throw ModelNotFoundException("Todo", todoId)

        if (todo.user.id != principal.id) throw AuthorizationException("수정 권한이 없습니다.")

        val (title, description) = request

        todo.title = title
        todo.description = description

        return todoRepository.save(todo).toResponse()
    }

    @Transactional
    fun deleteTodo(todoId: Long, principal: UserPrincipal) {
        val todo: Todo =
            todoRepository.findByIdOrNull(todoId) ?: throw ModelNotFoundException("Todo", todoId)
        if (todo.user.id != principal.id) throw AuthorizationException("삭제 권한이 없습니다.")
        todoRepository.delete(todo)
    }

    @Transactional
    fun changeCompletionState(todoId: Long, completionState: Boolean, principal: UserPrincipal): TodoResponse {
        val todo: Todo =
            todoRepository.findByIdOrNull(todoId) ?: throw ModelNotFoundException("Todo", todoId)

        if (todo.user.id != principal.id) throw AuthorizationException("수정 권한이 없습니다.")

        todo.completion = completionState

        return todoRepository.save(todo).toResponse()
    }

}
