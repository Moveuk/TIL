package com.algorithm_proj.programmers.level1.lessons147355

class Solution {
    //크기가 작은 부분문자열 - https://school.programmers.co.kr/learn/courses/30/lessons/147355?language=kotlin
    fun solution(t: String, p: String): Int {
        var answer: Int = 0
        val tSb = StringBuilder(t)
        val pLength = p.length
        for (start in 0..t.length - pLength) {
            val end = start + pLength
            //p조건이 1 <= p의 길이 <= 18이므로 t가 int를 초과할 수 있으므로 신경써서 비교를 해줘야함.
            if (tSb.substring(start, end).toLong() <= p.toLong()) answer++
        }
        return answer
    }
}