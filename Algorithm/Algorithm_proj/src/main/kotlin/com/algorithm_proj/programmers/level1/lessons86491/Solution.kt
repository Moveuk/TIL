package com.algorithm_proj.programmers.level1.lessons86491

class Solution {
    //최소직사각형 - https://school.programmers.co.kr/learn/courses/30/lessons/86491?language=kotlin
    fun solution(sizes: Array<IntArray>): Int {
        val minNMax = intArrayOf(0, 0)
        sizes.forEach { intArray: IntArray ->
            val eachMin = intArray[0].coerceAtMost(intArray[1])
            val eachMax = intArray[0].coerceAtLeast(intArray[1])
            if (minNMax[0] < eachMin) minNMax[0] = eachMin
            if (minNMax[1] < eachMax) minNMax[1] = eachMax
        }
        return minNMax[0] * minNMax[1]
    }
}