package com.moveuk.courseregistration.domain.course.repository

import com.moveuk.courseregistration.domain.course.model.Course
import com.moveuk.courseregistration.domain.course.model.CourseStatus
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface CustomCourseRepository {

    fun searchCourseListByTitle(title: String): List<Course>

    fun findByPageableAndStatus(pageable: Pageable, status: CourseStatus?): Page<Course>
}