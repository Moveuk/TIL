package com.moveuk.courseregistration.domain.course.service

import com.moveuk.courseregistration.domain.course.dto.CourseResponse
import com.moveuk.courseregistration.domain.course.dto.CreateCourseRequest
import com.moveuk.courseregistration.domain.course.dto.UpdateCourseRequest
import com.moveuk.courseregistration.domain.course.model.Course
import com.moveuk.courseregistration.domain.course.model.CourseStatus
import com.moveuk.courseregistration.domain.course.model.toResponse
import com.moveuk.courseregistration.domain.course.repository.CourseRepository
import com.moveuk.courseregistration.domain.courseapplication.dto.ApplyCourseRequest
import com.moveuk.courseregistration.domain.courseapplication.dto.CourseApplicationResponse
import com.moveuk.courseregistration.domain.courseapplication.dto.UpdateApplicationStatusRequest
import com.moveuk.courseregistration.domain.courseapplication.model.CourseApplication
import com.moveuk.courseregistration.domain.courseapplication.model.CourseApplicationStatus
import com.moveuk.courseregistration.domain.courseapplication.model.toResponse
import com.moveuk.courseregistration.domain.courseapplication.repository.CourseApplicationRepository
import com.moveuk.courseregistration.domain.exception.ModelNotFoundException
import com.moveuk.courseregistration.domain.lecture.dto.AddLectureRequest
import com.moveuk.courseregistration.domain.lecture.dto.LectureResponse
import com.moveuk.courseregistration.domain.lecture.dto.UpdateLectureRequest
import com.moveuk.courseregistration.domain.lecture.model.Lecture
import com.moveuk.courseregistration.domain.lecture.model.toResponse
import com.moveuk.courseregistration.domain.lecture.repository.LectureRepository
import com.moveuk.courseregistration.domain.user.repository.UserRepository
import com.moveuk.courseregistration.infra.aop.StopWatch
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CourseServiceImpl(
    private val courseRepository: CourseRepository,
    private val lectureRepository: LectureRepository,
    private val courseApplicationRepository: CourseApplicationRepository,
    private val userRepository: UserRepository,
) : CourseService {

    override fun getPaginatedCourseList(pageable: Pageable, status: String?): Page<CourseResponse> {
        val courseStatus = when (status) {
            "OPEN" -> CourseStatus.OPEN
            "CLOSED" -> CourseStatus.CLOSED
            null -> null
            else -> throw IllegalArgumentException("The status is invalid");
        }

        return courseRepository.findByPageableAndStatus(pageable, courseStatus).map { it.toResponse() }
    }

    override fun searchCourseListByTitle(title: String): List<CourseResponse> {
        return courseRepository.searchCourseListByTitle(title).map { it.toResponse() }
    }


    override fun getAllCourseList(): List<CourseResponse> {
        // TODO: DB에서 모든 Course 목록을 조회하여 CourseResponse 목록으로 변환 후 반환
        return courseRepository.findAll().map { it.toResponse() }
    }

    @StopWatch
    override fun getCourseById(courseId: Long): CourseResponse {
        // TODO: 만약 courseId에 해당하는 Course가 없다면 throw ModelNotFoundException
        // TODO: DB에서 ID기반으로 Course 가져와서 CourseResponse로 변환 후 반환
        val course = courseRepository.findByIdOrNull(courseId) ?: throw ModelNotFoundException("Course", courseId)
        return course.toResponse()
    }

    @Transactional
    override fun createCourse(request: CreateCourseRequest): CourseResponse {
        // TODO: request를 Course로 변환 후 DB에 저장
        return courseRepository.save(
            Course(
                title = request.title,
                description = request.description,
                status = CourseStatus.OPEN,
            )
        ).toResponse()
    }

    @Transactional
    override fun updateCourse(courseId: Long, request: UpdateCourseRequest): CourseResponse {
        // TODO: 만약 courseId에 해당하는 Course가 없다면 throw ModelNotFoundException
        // TODO: DB에서 courseId에 해당하는 Course를 가져와서 request기반으로 업데이트 후 DB에 저장, 결과를 CourseResponse로 변환 후 반환
        val course = courseRepository.findByIdOrNull(courseId) ?: throw ModelNotFoundException("Course", courseId)
        val (title, description) = request

        course.title = title
        course.description = description

        return courseRepository.save(course).toResponse()
    }

    @Transactional
    override fun deleteCourse(courseId: Long) {
        // TODO: 만약 courseId에 해당하는 Course가 없다면 throw ModelNotFoundException
        // TODO :DB에서 courseId에 해당하는 Course를 삭제, 연관된 CourseApplication과 Lecture도 모두 삭제
        val course = courseRepository.findByIdOrNull(courseId) ?: throw ModelNotFoundException("Course", courseId)
        courseRepository.delete(course)
    }

    override fun getLectureList(courseId: Long): List<LectureResponse> {
        // TODO: 만약 courseId에 해당하는 Course가 없다면 throw ModelNotFoundException
        // TODO: DB에서 courseId에 해당하는 Course목록을 가져오고, 하위 lecture들을 가져온 다음, LectureResopnse로 변환해서 반환
        return lectureRepository.findAllByCourseId(courseId).map { it.toResponse() }
    }

    override fun getLecture(courseId: Long, lectureId: Long): LectureResponse {
        // TODO: 만약 courseId, lectureId에 해당하는 Lecture가 없다면 throw ModelNotFoundException
        // TODO: DB에서 courseId, lectureId에 해당하는 Lecture를 가져와서 LectureResponse로 변환 후 반환
        val lecture = lectureRepository.findByIdOrNull(lectureId)
            ?: throw ModelNotFoundException("Lecture", lectureId)

        return lecture.toResponse()
    }

    @Transactional
    override fun addLecture(courseId: Long, request: AddLectureRequest): LectureResponse {
        // TODO: 만약 courseId에 해당하는 Course가 없다면 throw ModelNotFoundException
        // TODO: DB에서 courseId에 해당하는 Course를 가져와서 Lecture를 추가 후 DB에 저장, 결과를을 LectureResponse로 변환 후 반환
        val course = courseRepository.findByIdOrNull(courseId) ?: throw ModelNotFoundException("Course", courseId)

        val lecture = Lecture(
            title = request.title,
            videoUrl = request.videoUrl,
            course = course
        )
        return lectureRepository.save(lecture).toResponse()
    }

    @Transactional
    override fun updateLecture(courseId: Long, lectureId: Long, request: UpdateLectureRequest): LectureResponse {
        // TODO: 만약 courseId, lectureId에 해당하는 Lecture가 없다면 throw ModelNotFoundException
        /* TODO: DB에서 courseId, lectureId에 해당하는 Lecture를 가져와서
            request로 업데이트 후 DB에 저장, 결과를을 LectureResponse로 변환 후 반환 */
        val lecture = lectureRepository.findByIdOrNull(lectureId)
            ?: throw ModelNotFoundException("Lecture", lectureId)

        val (title, videoUrl) = request
        lecture.title = title
        lecture.videoUrl = videoUrl

        return lectureRepository.save(lecture).toResponse()
    }

    @Transactional
    override fun removeLecture(courseId: Long, lectureId: Long) {
        // TODO: 만약 courseId에 해당하는 Course가 없다면 throw ModelNotFoundException
        // TODO: DB에서 courseId, lectureId에 해당하는 Lecture를 가져오고, 삭제
        val course = courseRepository.findByIdOrNull(courseId) ?: throw ModelNotFoundException("Course", courseId)
        val lecture = lectureRepository.findByIdOrNull(lectureId)
            ?: throw ModelNotFoundException("Lecture", lectureId)

//        course.removeLecture(lecture)
//
//        // Lecture에 영속성을 전파
//        courseRepository.save(course)
        lectureRepository.delete(lecture)
    }

    @Transactional
    override fun applyCourse(courseId: Long, request: ApplyCourseRequest): CourseApplicationResponse {
        // TODO: 만약 courseId에 해당하는 Course가 없다면 throw ModelNotFoundException
        // TODO: 만약 course가 이미 마감됐다면, throw IllegalStateException
        // TODO: 이미 신청했다면, throw IllegalStateException
        val course = courseRepository.findByIdOrNull(courseId) ?: throw ModelNotFoundException("Course", courseId)
        val user = userRepository.findByIdOrNull(request.userId)
            ?: throw ModelNotFoundException("User", request.userId)

        // Course 마감여부 체크
        if (course.isClosed()) {
            throw IllegalStateException("Course is already closed. courseId: $courseId")
        }

        // CourseApplication 중복 체크
        if (courseApplicationRepository.existsByCourseIdAndUserId(courseId, request.userId)) {
            throw IllegalStateException("Already applied. courseId: $courseId, userId: ${request.userId}")
        }

        val courseApplication = CourseApplication(
            course = course,
            user = user,
        )
        course.addCourseApplication(courseApplication)
        // CourseApplication에 영속성을 전파
        courseRepository.save(course)

        return courseApplication.toResponse()
    }

    override fun getCourseApplication(courseId: Long, applicationId: Long): CourseApplicationResponse {
        // TODO: 만약 courseId, applicationId에 해당하는 CourseApplication이 없다면 throw ModelNotFoundException
        // TODO: DB에서 courseId, applicationId에 해당하는 CourseApplication을 가져와서 CourseApplicationResponse로 변환 후 반환
        val application = courseApplicationRepository.findByCourseIdAndId(courseId, applicationId)
            ?: throw ModelNotFoundException("CourseApplication", applicationId)

        return application.toResponse()
    }

    override fun getCourseApplicationList(courseId: Long): List<CourseApplicationResponse> {
        // TODO: 만약 courseId에 해당하는 Course가 없다면 throw ModelNotFoundException
        // TODO: DB에서 courseId에 해당하는 Course를 가져오고, 하위 courseApplication들을 CourseApplicationResponse로 변환 후 반환
        val course = courseRepository.findByIdOrNull(courseId) ?: throw ModelNotFoundException("Course", courseId)

        return course.courseApplications.map { it.toResponse() }
    }

    @Transactional
    override fun updateCourseApplicationStatus(
        courseId: Long,
        applicationId: Long,
        request: UpdateApplicationStatusRequest
    ): CourseApplicationResponse {
        // TODO: 만약 courseId, applicationId에 해당하는 CourseApplication이 없다면 throw ModelNotFoundException
        // TODO: 만약 status가 이미 변경된 상태면 throw IllegalStateException
        // TODO: Course의 status가 CLOSED상태 일시 throw IllegalStateException
        // TODO: 승인을 하는 케이스일 경우, course의 numApplicants와 maxApplicants가 동일하면, course의 상태를 CLOSED로 변경
        // TODO: DB에서 courseApplication을 가져오고, status를 request로 업데이트 후 DB에 저장, 결과를 CourseApplicationResponse로 변환 후 반환
        val course = courseRepository.findByIdOrNull(courseId) ?: throw ModelNotFoundException("Course", courseId)
        val application = courseApplicationRepository.findByCourseIdAndId(courseId, applicationId)
            ?: throw ModelNotFoundException("CourseApplication", applicationId)

        // 이미 승인 혹은 거절된 신청건인지 체크
        if (application.isProceeded()) {
            throw IllegalStateException("Application is already proceeded. applicationId: $applicationId")
        }

        // Course 마감여부 체크
        if (course.isClosed()) {
            throw IllegalStateException("Course is already closed. courseId: $courseId")
        }

        // 승인 / 거절 따른 처리
        when (request.status) {
            // 승인 일때
            CourseApplicationStatus.ACCEPTED.name -> {
                // 승인 처리
                application.accept()
                // Course의 신청 인원 늘려줌
                course.addApplicant()
                // 만약 신청 인원이 꽉 찬다면 마감 처리
                if (course.isFull()) {
                    course.close()
                }
                courseRepository.save(course)
            }

            // 거절 일때
            CourseApplicationStatus.REJECTED.name -> {
                // 거절 처리
                application.reject()
            }
            // 승인 거절이 아닌 다른 인자가 들어올 경우 에러 처리
            else -> {
                throw IllegalArgumentException("Invalid status: ${request.status}")
            }
        }

        return courseApplicationRepository.save(application).toResponse()
    }

}
