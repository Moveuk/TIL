package com.moveuk.courseregistration.domain.course.repository

import com.moveuk.courseregistration.domain.course.model.Course
import org.springframework.data.jpa.repository.JpaRepository

interface CourseRepository : JpaRepository<Course, Long>, CustomCourseRepository {}