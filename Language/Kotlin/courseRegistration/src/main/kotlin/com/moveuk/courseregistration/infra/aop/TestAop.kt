package com.moveuk.courseregistration.infra.aop

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around

//@Aspect
//@Component
class TestAop {

    @Around("execution(* com.moveuk.courseregistration.domain.course.service.CourseService.getCourseById(..))")
    fun thisIsAdvice(joinPoint: ProceedingJoinPoint) {
        println("AOP START!!!")
        joinPoint.proceed()
        println("AOP END!!!")
    }

}