package com.algorithm_proj.programmers.level2.lessons42842

import kotlin.math.sqrt

class Solution {
    //카펫 - https://school.programmers.co.kr/learn/courses/30/lessons/42842
    fun solution(brown: Int, yellow: Int): IntArray {
        val answer = intArrayOf()
        val totalLength = brown + yellow
        val sqrt = sqrt(totalLength.toDouble()).toInt()

        for (i in sqrt downTo 1) {
            if (i * i == totalLength && (i - 2) * (i - 2) == yellow) {
                return intArrayOf(i, i)
            } else if (totalLength % i == 0 && (i - 2) * (totalLength / i - 2) == yellow) {
                return intArrayOf(totalLength / i, i)
            }
        }
        return answer
    }

    //    fun solution(brown: Int, red: Int): IntArray {
    //        return (1..red)
    //            .filter { red % it == 0 }
    //            .first { brown == (red / it * 2) + (it * 2) + 4 }
    //            .let { intArrayOf(red / it + 2, it + 2) }
    //    }
}