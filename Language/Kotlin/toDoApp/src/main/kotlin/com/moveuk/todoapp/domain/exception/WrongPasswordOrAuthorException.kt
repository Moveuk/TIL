package com.moveuk.todoapp.domain.exception

data class WrongPasswordOrAuthorException(val modelName: String, val id: Long?) :
    RuntimeException("Wrong Password or Author For id: $id of Model $modelName")