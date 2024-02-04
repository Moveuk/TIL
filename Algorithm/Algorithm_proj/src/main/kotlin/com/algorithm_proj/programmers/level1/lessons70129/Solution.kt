package com.algorithm_proj.programmers.level1.lessons70129

class Solution {
    //이진 변환 반복하기 - https://school.programmers.co.kr/learn/courses/30/lessons/70129?language=kotlin
    fun solution(s: String): IntArray {
        var temps = s
        val answer = intArrayOf(0, 0)
        while (temps != "1") {
            while (temps.contains("0")) {
                temps = temps.replaceFirst("0".toRegex(), "")
                answer[1]++
            }
            temps = Integer.toBinaryString(temps.length)
            answer[0]++
        }
        return answer
    }
}