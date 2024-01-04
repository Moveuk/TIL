package com.moveuk.todoapp.domain.exception

import com.moveuk.todoapp.domain.exception.dto.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class AuthenticationNAuthorizationFailureHandler {

    @ExceptionHandler(AuthenticationException::class)
    fun onAuthenticationFailure(e: AuthenticationException): ResponseEntity<ErrorResponse> {
        val httpStatus: HttpStatus
        val message: String

        if (e is EmailNotFoundException || e is BadCredentialsException) {
            httpStatus = HttpStatus.BAD_REQUEST
            message = e.message
        } else {
            httpStatus = HttpStatus.BAD_REQUEST
            message = e.message
        }

        return ResponseEntity.status(httpStatus).body(ErrorResponse(message))
    }

    @ExceptionHandler(AuthorizationException::class)
    fun onAuthorizationExceptionFailure(e: AuthorizationException): ResponseEntity<ErrorResponse> {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponse(e.message))
    }
}