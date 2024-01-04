package com.moveuk.todoapp.domain.todo.controller

import com.moveuk.todoapp.domain.todo.dto.todo.*
import com.moveuk.todoapp.domain.todo.service.TodoService
import com.moveuk.todoapp.domain.user.service.AuthService
import jakarta.servlet.http.HttpServletRequest
import jakarta.validation.Valid
import jakarta.websocket.server.PathParam
import org.springframework.data.domain.Page
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@Validated
@RequestMapping("/todos")
@RestController
class TodoController(
    private val todoService: TodoService,
    private val authService: AuthService
) {

    @GetMapping
    fun getTodos(
        @PathParam("sortProperty") sortProperty: SortProperty?,
        @PathParam("sortOrder") sortOrder: SortOrder?,
        @PathParam("author") author: String?,
        @PathParam("pageNumber") pageNumber: Int?,
    ): ResponseEntity<Page<TodoResponse>> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(todoService.getAllTodos(sortProperty, sortOrder, author, pageNumber))
    }

    @GetMapping("/{todoId}")
    fun getTodo(@PathVariable todoId: Long): ResponseEntity<TodoResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(todoService.getTodoByID(todoId))
    }

    @PostMapping
    fun createTodo(
        @Valid @RequestBody createTodoRequest: CreateTodoRequest,
        request: HttpServletRequest
    ): ResponseEntity<TodoResponse> {
        //저장된 세션이라면 세션의 user 데이터 반환
        val authenticatedUser = authService.checkAuthenticatedUser(request)
        //로그인 상태면 작성 시작
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(todoService.createTodo(createTodoRequest, authenticatedUser))
    }

    @PutMapping("/{todoId}")
    fun updateTodo(
        @PathVariable todoId: Long,
        @Valid @RequestBody updateTodoRequest: UpdateTodoRequest,
        request: HttpServletRequest
    ): ResponseEntity<TodoResponse> {
        //저장된 세션이라면 세션의 user 데이터 반환
        val authenticatedUser = authService.checkAuthenticatedUser(request)
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(todoService.updateTodo(todoId, updateTodoRequest, authenticatedUser))
    }

    @DeleteMapping
    fun deleteTodo(
        @PathParam("todoId") todoId: Long,
        request: HttpServletRequest
    ): ResponseEntity<Unit> {
        //저장된 세션이라면 세션의 user 데이터 반환
        val authenticatedUser = authService.checkAuthenticatedUser(request)
        todoService.deleteTodo(todoId, authenticatedUser)
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .build()
    }

    @PutMapping("/{todoId}/completion")
    fun changeCompletionState(
        @PathVariable todoId: Long,
        @PathParam("state") completionState: Boolean,
        request: HttpServletRequest
    ): ResponseEntity<TodoResponse> {
        //저장된 세션이라면 세션의 user 데이터 반환
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(
                authService.checkAuthenticatedUser(request).let {
                    todoService.changeCompletionState(todoId, completionState, it)
                }
            )
    }

}