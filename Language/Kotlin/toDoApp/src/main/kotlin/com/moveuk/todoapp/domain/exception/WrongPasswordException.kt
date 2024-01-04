package com.moveuk.todoapp.domain.exception

data class WrongPasswordException(val modelName: String, val id: Long?) :
    RuntimeException("$id 번 $modelName 의 비밀번호가 다릅니다.")