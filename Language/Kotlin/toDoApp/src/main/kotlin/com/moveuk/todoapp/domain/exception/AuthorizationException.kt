package com.moveuk.todoapp.domain.exception

open class AuthorizationException(override val message: String) :
    RuntimeException(message)