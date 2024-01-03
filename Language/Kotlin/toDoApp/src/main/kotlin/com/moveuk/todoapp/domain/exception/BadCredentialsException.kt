package com.moveuk.todoapp.domain.exception

data class BadCredentialsException(
    override val message: String = "이메일 또는 비밀번호가 맞지 않습니다. 다시 확인해 주세요."
) :
    AuthenticationException(message)
