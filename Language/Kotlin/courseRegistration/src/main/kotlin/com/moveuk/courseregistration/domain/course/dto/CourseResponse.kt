package com.moveuk.courseregistration.domain.course.dto

import com.moveuk.courseregistration.domain.lecture.dto.LectureResponse

data class CourseResponse(
    val id: Long,
    val title: String,
    val description: String?,
    val status: String,
    val maxApplicants: Int,
    val numApplicants: Int,
    val lectures: List<LectureResponse>,
)
