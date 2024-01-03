package com.moveuk.todoapp.domain.exception

open class AuthenticationException(override val message: String) :
    RuntimeException(message)