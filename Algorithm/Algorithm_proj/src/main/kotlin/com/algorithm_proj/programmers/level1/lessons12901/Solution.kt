package com.algorithm_proj.programmers.level1.lessons12901

class Solution {
    //2016년 - https://school.programmers.co.kr/learn/courses/30/lessons/12901
    fun solution(a: Int, b: Int): String? {
        var answer = ""

        val compensateValue = 4 // 인덱스 보정용 값
        val index: Int // 요일 인덱스
        val day = arrayOf("SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT")
        val daysOfMonth = intArrayOf(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
        var days = 0

        for (i in 0 until a - 1) { // 지난 달 일자 더하기
            days += daysOfMonth[i]
        }
        days += b + compensateValue // 일자 더하기

        index = (days % 7)

        answer = day[index] //  7일로 나누기
        return answer
    }
}