package com.moveuk.courseregistration.infra.aop

@Target(AnnotationTarget.FUNCTION) //어노테이션이 적용될 타겟 정보 Function이외에도 FILE, TYPE.. 등등이 있음,
@Retention(AnnotationRetention.RUNTIME) //어노테이션이 어느 시점까지 사용될 수 있는지에 대한 내용
annotation class StopWatch()
