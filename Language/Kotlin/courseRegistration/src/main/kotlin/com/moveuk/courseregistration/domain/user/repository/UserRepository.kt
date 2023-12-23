package com.moveuk.courseregistration.domain.user.repository

import com.moveuk.courseregistration.domain.user.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {

    fun existsByEmail(email: String): Boolean
}