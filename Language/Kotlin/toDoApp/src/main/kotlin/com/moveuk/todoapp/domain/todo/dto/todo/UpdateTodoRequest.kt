package com.moveuk.todoapp.domain.todo.dto.todo

import jakarta.validation.constraints.Size

data class UpdateTodoRequest(
    @field:Size(min = 1, max = 200, message = "할 일 제목의 글자수는 {min}자 이상 {max} 자 이하여야 합니다.")
    val title: String,
    @field:Size(min = 1, max = 1000, message = "할 일 본문의 글자수는 {min}자 이상 {max} 자 이하여야 합니다.")
    val description: String?,
    val author: String,
)
