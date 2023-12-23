package com.moveuk.courseregistration.domain.course.dto

data class UpdateCourseRequest(
    val title: String,
    val description: String?,
)