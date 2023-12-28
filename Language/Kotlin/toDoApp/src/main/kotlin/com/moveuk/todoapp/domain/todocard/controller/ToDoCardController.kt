package com.moveuk.todoapp.domain.todocard.controller

import com.moveuk.todoapp.domain.todocard.dto.*
import com.moveuk.todoapp.domain.todocard.service.ToDoCardService
import jakarta.validation.Valid
import jakarta.validation.constraints.NotBlank
import jakarta.websocket.server.PathParam
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@Validated
@RequestMapping("/to-do-cards")
@RestController
class ToDoCardController(
    private val toDoCardService: ToDoCardService
) {

    @GetMapping
    fun getToDoCardList(
        @PathParam("sortProperty") sortProperty: SortProperty?,
        @PathParam("sortOrder") sortOrder: SortOrder?,
        @PathParam("author") author: String?
    ): ResponseEntity<List<ToDoCardResponse>> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(toDoCardService.getAllToDoCardList(sortProperty, sortOrder, author))
    }

    @GetMapping("/{toDoCardId}")
    fun getToDoCard(@PathVariable toDoCardId: Long): ResponseEntity<ToDoCardResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(toDoCardService.getToDoCardByID(toDoCardId))
    }

    @PostMapping
    fun createToDoCard(@Valid @RequestBody createToDoCardRequest: CreateToDoCardRequest): ResponseEntity<ToDoCardResponse> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(toDoCardService.createToDoCard(createToDoCardRequest))
    }

    @PutMapping("/{toDoCardId}")
    fun updateToDoCard(
        @PathVariable @NotBlank toDoCardId: Long,
        @Valid @RequestBody updateToDoCardRequest: UpdateToDoCardRequest
    ): ResponseEntity<ToDoCardResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(toDoCardService.updateToDoCard(toDoCardId, updateToDoCardRequest))
    }

    @DeleteMapping
    fun deleteToDoCard(@PathParam("toDoCardId") toDoCardId: Long): ResponseEntity<Unit> {
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