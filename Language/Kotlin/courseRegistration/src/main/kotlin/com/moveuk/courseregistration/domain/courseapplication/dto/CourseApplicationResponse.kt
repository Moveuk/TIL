package com.moveuk.courseregistration.domain.courseapplication.dto

import com.moveuk.courseregistration.domain.course.dto.CourseResponse
import com.moveuk.courseregistration.domain.user.dto.UserResponse

data class CourseApplicationResponse(
    val id: Long,
    val course: CourseResponse,
    val user: UserResponse,
    val status: String,
)