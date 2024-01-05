package com.algorithm_proj.programmers.level1.lessons131128

import kotlin.math.min

class Solution {
    //숫자 짝꿍 - https://school.programmers.co.kr/learn/courses/30/lessons/131128?language=kotlin
    fun solution(X: String, Y: String): String {
        var answer = StringBuilder()
        val countIntMap = mutableMapOf<Int, Int>()

        for (index in 0..9) {
            val countX = X.toSingleDigitList().count { index == it }
            val countY = Y.toSingleDigitList().count { index == it }
            countIntMap[index] = min(countX, countY)
        }

        countIntMap.entries
            .sortedByDescending { pair -> pair.key }
            .forEach {
                if (it.value != 0) {
                    for (index in 1..it.value) {
                        answer.append(it.key)
                    }
                }
            }

        if (answer.toString() == "") answer.append("-1")
        //숫자가 너무 클 때 Long에도 못담다 보니 런타임에러가 났었음.
        //이 로직은 "0000"인 경우 0으로 쉽게 바꿔주려고 한 것인데 300만 총 600만 문자열이 될 수 있어 문제가 되는 듯함.
        if (answer.length < 10) {
            return answer.toString().toLong().toString()
        }

        return answer.toString()
    }

    private fun String.toSingleDigitList() = map {
        "$it".toIntOrNull()
    }.filterNotNull()
}