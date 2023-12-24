package com.moveuk.todoapp.domain.todocard.controller

import com.moveuk.todoapp.domain.exception.ModelNotFoundException
import com.moveuk.todoapp.domain.exception.dto.ErrorResponse
import com.moveuk.todoapp.domain.todocard.dto.CreateToDoCardRequest
import com.moveuk.todoapp.domain.todocard.dto.ToDoCardResponse
import com.moveuk.todoapp.domain.todocard.dto.UpdateToDoCardRequest
import com.moveuk.todoapp.domain.todocard.service.ToDoCardService
import jakarta.websocket.server.PathParam
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/to-do-cards")
@RestController
class ToDoCardController(
    private val toDoCardService: ToDoCardService
) {

    @GetMapping
    fun getToDoCardList(): ResponseEntity<List<ToDoCardResponse>> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(toDoCardService.getAllToDoCardList())
    }

    @GetMapping("/{toDoCardId}")
    fun getToDoCard(@PathVariable toDoCardId: Long): ResponseEntity<ToDoCardResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(toDoCardService.getToDoCardByID(toDoCardId))
    }

    @ExceptionHandler(ModelNotFoundException::class)
    fun handleModelNotFoundException(e: ModelNotFoundException): ResponseEntity<ErrorResponse> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse(e.message))
    }

    @PostMapping
    fun createToDoCard(@RequestBody createToDoCardRequest: CreateToDoCardRequest): ResponseEntity<ToDoCardResponse> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(toDoCardService.createToDoCard(createToDoCardRequest))
    }

    @PutMapping("/{toDoCardId}")
    fun updateToDoCard(
        @PathVariable toDoCardId: Long,
        @RequestBody updateToDoCardRequest: UpdateToDoCardRequest
    ): ResponseEntity<ToDoCardResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(toDoCardService.updateToDoCard(toDoCardId, updateToDoCardRequest))
    }

    @DeleteMapping("/{toDoCardId}")
    fun deleteToDoCard(@PathVariable toDoCardId: Long): ResponseEntity<Unit> {
        toDoCardService.deleteToDoCard(toDoCardId)
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .build()
    }

    @PutMapping("/{toDoCardId}/completion")
    fun changeCompletionState(
        @PathVariable toDoCardId: Long,
        @PathParam("state") completionState: Boolean
    ): ResponseEntity<ToDoCardResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(toDoCardService.changeCompletionState(toDoCardId, completionState))
    }

}