package com.moveuk.todoapp.domain.todo.model

import com.moveuk.todoapp.domain.user.model.Profile
import com.moveuk.todoapp.domain.user.model.User
import com.moveuk.todoapp.domain.user.model.UserRole
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class TodoTest {
    private val todo = Todo(
        title = "title",
        user = User(
            email = "test@test.com",
            profile = Profile(
                nickname = "nickname"
            ),
            password = "1234",
            role = UserRole.ADMIN
        )
    )

    @Test
    fun `completion 상태 변경시 변경되는지 확인`() {
        // GIVEN
        val status = true

        // WHEN
        todo.toggleCompletion(status)

        // THEN
        todo.completion shouldBe true
    }
}