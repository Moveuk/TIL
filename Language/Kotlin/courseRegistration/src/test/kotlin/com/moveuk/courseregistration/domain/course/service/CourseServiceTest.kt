package com.moveuk.courseregistration.domain.course.service

import com.moveuk.courseregistration.domain.course.repository.CourseRepository
import com.moveuk.courseregistration.domain.courseapplication.repository.CourseApplicationRepository
import com.moveuk.courseregistration.domain.exception.ModelNotFoundException
import com.moveuk.courseregistration.domain.lecture.repository.LectureRepository
import com.moveuk.courseregistration.domain.user.repository.UserRepository
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.extensions.spring.SpringExtension
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.repository.findByIdOrNull

@SpringBootTest
@ExtendWith(MockKExtension::class)
class CourseServiceTest : BehaviorSpec({
    extension(SpringExtension)

    afterContainer {
        clearAllMocks()
    }

    val courseRepository = mockk<CourseRepository>()
    val lectureRepository = mockk<LectureRepository>()
    val courseApplicationRepository = mockk<CourseApplicationRepository>()
    val userRepository = mockk<UserRepository>()

    val courseService =
        CourseServiceImpl(courseRepository, lectureRepository, courseApplicationRepository, userRepository)

    Given("Course 목록이 존재하지 않을 때") {
        When("특정 Course를 요청하면") {
            Then("ModelNotFoundException이 발생해야한다.") {

                // given
                val courseId = 1L
                every { courseRepository.findByIdOrNull(any()) } returns null

                shouldThrow<ModelNotFoundException> {
                    println( courseService.getCourseById(courseId))
                }

            }
        }

        When("Course 목록을 요청하면") {
            //Then...
        }
    }
})