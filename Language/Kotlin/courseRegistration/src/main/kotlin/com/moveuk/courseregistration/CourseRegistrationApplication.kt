package com.moveuk.courseregistration

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.EnableAspectJAutoProxy

@EnableAspectJAutoProxy //Spring이 기본적으로 AspectJ를 사용했기 때문.
@SpringBootApplication
class CourseRegistrationApplication

fun main(args: Array<String>) {
    runApplication<CourseRegistrationApplication>(*args)
}
