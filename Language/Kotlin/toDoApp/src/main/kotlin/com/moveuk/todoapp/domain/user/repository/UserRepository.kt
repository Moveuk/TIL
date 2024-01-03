package com.moveuk.todoapp.domain.todocard.repository

import com.moveuk.todoapp.domain.user.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findUserByEmail(email: String): User?

    fun existsUserByEmail(email: String): Boolean
}
