package com.moveuk.todoapp.domain.exception

data class EmailNotFoundException(val value: String) :
    AuthenticationException("해당 이메일 $value 은 존재하지 않는 이메일입니다.")