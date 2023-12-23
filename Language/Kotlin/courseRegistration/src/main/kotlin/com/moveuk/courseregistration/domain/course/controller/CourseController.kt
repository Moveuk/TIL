package com.moveuk.courseregistration.domain.course.controller

import com.moveuk.courseregistration.domain.course.dto.CourseResponse
import com.moveuk.courseregistration.domain.course.dto.CreateCourseRequest
import com.moveuk.courseregistration.domain.course.dto.UpdateCourseRequest
import com.moveuk.courseregistration.domain.course.service.CourseService
import com.moveuk.courseregistration.domain.exception.ModelNotFoundException
import com.moveuk.courseregistration.domain.exception.dto.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/courses")
@RestController
class CourseController(
    private val courseService: CourseService
) {

    @GetMapping()
    fun getCourseList(): ResponseEntity<List<CourseResponse>> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(courseService.getAllCourseList())
    }

    @GetMapping("/{courseId}")
    fun getCourse(@PathVariable courseId: Long): ResponseEntity<CourseResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(courseService.getCourseById(courseId))
    }

    @ExceptionHandler(ModelNotFoundException::class)
    fun handleModelNotFoundException(e: ModelNotFoundException): ResponseEntity<ErrorResponse> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse(e.message))
    }

    @PostMapping
    fun createCourse(@RequestBody createCourseRequest: CreateCourseRequest): ResponseEntity<CourseResponse> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(courseService.createCourse(createCourseRequest))
    }

    @PutMapping("/{courseId}")
    fun updateCourse(
        @PathVariable courseId: Long,
        @RequestBody updateCourseRequest: UpdateCourseRequest
    ): ResponseEntity<CourseResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(courseService.updateCourse(courseId, updateCourseRequest))
    }

    @DeleteMapping("/{courseId}")
    fun deleteCourse(@PathVariable courseId: Long): ResponseEntity<Unit> {
        courseService.deleteCourse(courseId)
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .build()
    }

}
