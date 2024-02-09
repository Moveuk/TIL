package com.algorithm_proj.programmers.level1.lessons12953

import kotlin.math.max
import kotlin.math.min

class Solution {
    //N개의 최소공배수 - https://school.programmers.co.kr/learn/courses/30/lessons/12953?language=kotlin
    fun solution(arr: IntArray): Int {
        var answer = 1

        for (i in arr) {
            val max = max(answer, i)
            val min = min(answer, i)

            var gcd = 1
            if (max % min == 0) {
                gcd = min
            } else {
                var b = min
                var c = max % min
                while (true) {
                    if (b % c == 0) {
                        gcd = c
                        break
                    } else {
                        val tmp = c
                        c = b % c
                        b = tmp
                    }
                }
            }
            answer = max * min / gcd
        }

        return answer
    }
}