package com.moveuk.todoapp.domain.todo.controller

import com.moveuk.todoapp.domain.todo.dto.todo.CreateTodoRequest
import com.moveuk.todoapp.domain.todo.dto.todo.TodoResponse
import com.moveuk.todoapp.domain.todo.dto.todo.UpdateTodoRequest
import com.moveuk.todoapp.domain.todo.service.TodoService
import com.moveuk.todoapp.infra.security.UserPrincipal
import jakarta.servlet.http.HttpServletRequest
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@Validated
@RequestMapping("/todos")
@RestController
class TodoController(
    private val todoService: TodoService
) {

    @GetMapping
    fun getTodos(
        @PageableDefault(size = 10, sort = ["id"]) pageable: Pageable,
        @RequestParam("nickname") nickname: String?
    ): ResponseEntity<Page<TodoResponse>> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(todoService.getAllTodos(pageable, nickname))
    }

    @GetMapping("/{todoId}")
    fun getTodo(@PathVariable todoId: Long): ResponseEntity<TodoResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(todoService.getTodoByID(todoId))
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @PostMapping
    fun createTodo(
        @Valid @RequestBody createTodoRequest: CreateTodoRequest,
        request: HttpServletRequest
    ): ResponseEntity<TodoResponse> {
        return (SecurityContextHolder
            .getContext()
            .authentication
            .principal as UserPrincipal).let { userPrincipal ->
            todoService.createTodo(createTodoRequest, userPrincipal)
        }.let {
            ResponseEntity
                .status(HttpStatus.CREATED)
                .body(it)
        }
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @PutMapping("/{todoId}")
    fun updateTodo(
        @PathVariable todoId: Long,
        @Valid @RequestBody updateTodoRequest: UpdateTodoRequest,
        request: HttpServletRequest
    ): ResponseEntity<TodoResponse> {
        return (SecurityContextHolder
            .getContext()
            .authentication
            .principal as UserPrincipal).let { userPrincipal ->
            todoService.updateTodo(todoId, updateTodoRequest, userPrincipal)
        }.let {
            ResponseEntity
                .status(HttpStatus.OK)
                .body(it)
        }
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @DeleteMapping("/{todoId}")
    fun deleteTodo(
        @PathVariable("todoId") todoId: Long,
        request: HttpServletRequest
    ): ResponseEntity<Unit> {
        return (SecurityContextHolder
            .getContext()
            .authentication
            .principal as UserPrincipal).let { userPrincipal ->
            todoService.deleteTodo(todoId, userPrincipal)
        }.let {
            ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(it)
        }
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @PutMapping("/{todoId}/completion")
    fun changeCompletionState(
        @PathVariable todoId: Long,
        @RequestParam("state") completionState: Boolean,
        request: HttpServletRequest
    ): ResponseEntity<TodoResponse> {
        return (SecurityContextHolder
            .getContext()
            .authentication
            .principal as UserPrincipal).let { userPrincipal ->
            todoService.changeCompletionState(todoId, completionState, userPrincipal)
        }.let {
            ResponseEntity
                .status(HttpStatus.OK)
                .body(it)
        }
    }

}