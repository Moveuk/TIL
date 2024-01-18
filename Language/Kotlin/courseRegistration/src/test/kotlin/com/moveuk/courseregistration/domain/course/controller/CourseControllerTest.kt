package com.moveuk.courseregistration.domain.course.controller

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.moveuk.courseregistration.domain.course.dto.CourseResponse
import com.moveuk.courseregistration.domain.course.service.CourseService
import com.moveuk.courseregistration.infra.security.jwt.JwtPlugin
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.extensions.spring.SpringExtension
import io.kotest.matchers.shouldBe
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockKExtension::class)
class CourseControllerTest @Autowired constructor(
    //명시적으로 @Autowired 달아주는 이유: 기본으로는 jupiter가 바라보고 있기 때문에 Spring에게 주입대상을 인지시킬 수 있도록 달아줌.
    private val mockMvc: MockMvc,
    private val jwtPlugin: JwtPlugin
) : DescribeSpec({//kotest가 제공하는 방식, 다른 테스트를 할 때는 기본 http를 사용해도 됨.
    extension(SpringExtension) //SpringExtension 받는 것을 말해줌.

    afterContainer {
        clearAllMocks()
    }

    val courseService = mockk<CourseService>()

    describe("GET /courses/{id}") {
        context("존재하는 ID를 요청할 때") {
            it("200 status code를 응답한다.") {
                val courseId = 1L

                //모든 요청에서 어떤 값을 요청하던지 CourseResponse를 반환한다.
                every { courseService.getCourseById(any()) } returns CourseResponse(
                    id = courseId,
                    title = "test_title",
                    description = "abc",
                    status = "OPEN",
                    maxApplicants = 30,
                    numApplicants = 10,
                    lectures = mutableListOf()
                )

                val jwtToken = jwtPlugin.generateAccessToken(
                    subject = courseId.toString(),
                    email = "test@test.com",
                    role = "STUDENT"
                )

                val result = mockMvc.perform(
                    get("/courses/$courseId")
                        .header("Authorization", "Bearer $jwtToken")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                ).andReturn()

                result.response.status shouldBe 200

                val responseDto = jacksonObjectMapper().readValue(
                    result.response.contentAsString,
                    CourseResponse::class.java
                )

                responseDto.id shouldBe courseId
            }
        }
    }
})