package com.algorithm_proj.programmers.level1.lessons92335

import kotlin.math.sqrt

class Solution {
    //k진수에서 소수 개수 구하기 - https://school.programmers.co.kr/learn/courses/30/lessons/92335?language=kotlin
    fun solution(n: Int, k: Int): Int {
        var answer: Int = 0
        val knum = StringBuilder()
        var ntemp = n

        while (ntemp >= 1) {
            knum.append(ntemp%k)
            ntemp/=k
        }

        val split = knum.reverse().split("0")

        split.forEach {
            seperatedNum ->
            if (seperatedNum == "" || seperatedNum == "1") return@forEach

            if ((2..sqrt(seperatedNum.toDouble()).toInt()).none { seperatedNum.toLong() % it.toLong() == 0L }) {
                answer++
            }
        }

        return answer
    }
}