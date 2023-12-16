package com.algorithm_proj.programmers.level1.lessons131705

class Solution {
    //삼총사 - https://school.programmers.co.kr/learn/courses/30/lessons/131705?language=kotlin
    fun solution(number: IntArray): Int {
        var answer: Int = 0

        for (firstNumIdx in 0..number.size - 3) {
            val totalArray = intArrayOf(number[firstNumIdx], 0, 0)
            for (secondNumIdx in 1..number.size - 2) {
                if (firstNumIdx >= secondNumIdx) continue
                totalArray[1] = number[secondNumIdx]
                for (thirdNumIdx in 2..number.size - 1) {
                    if (secondNumIdx >= thirdNumIdx) continue
                    totalArray[2] = number[thirdNumIdx]
                    if (totalArray.sum() == 0) answer++
                }
            }
        }

        return answer
    }
}