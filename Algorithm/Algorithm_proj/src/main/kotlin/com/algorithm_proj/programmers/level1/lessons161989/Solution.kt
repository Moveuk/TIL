package com.algorithm_proj.programmers.level1.lessons161989

class Solution {
    //덧칠하기 - https://school.programmers.co.kr/learn/courses/30/lessons/161989?language=kotlin
    fun solution(n: Int, m: Int, section: IntArray): Int {
        var answer: Int = 0
        val booleanSection = BooleanArray(n) {
            !section.contains(it + 1)
        }

        section.forEach {
            if (!booleanSection[it - 1]) answer++
            else return@forEach
            for (index in 0..<m) {
                if (it - 1 + index >= n) return@forEach
                booleanSection[it - 1 + index] = true
            }
        }

        return answer
    }
}