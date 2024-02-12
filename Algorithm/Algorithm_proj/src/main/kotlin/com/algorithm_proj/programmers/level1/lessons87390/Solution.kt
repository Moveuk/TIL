package com.algorithm_proj.programmers.level1.lessons87390

class Solution {
    //n^2 배열 자르기 - https://school.programmers.co.kr/learn/courses/30/lessons/87390
    fun solution(n: Int, left: Long, right: Long): IntArray {
        val answer = IntArray((right - left + 1).toInt())

        for (i in left / n - 1 until right / n + 1) {
            for (j in 0 until n) {
                val index = (n * i + j).toInt()
                if (n * i + j in left..right) {
                    answer[(index - left).toInt()] = (if (i > j) i + 1 else j + 1).toInt()
                }
            }
        }

        return answer
    }
}