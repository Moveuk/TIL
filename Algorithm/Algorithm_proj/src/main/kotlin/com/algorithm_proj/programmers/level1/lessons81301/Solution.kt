package com.algorithm_proj.programmers.level1.lessons81301

class Solution {
    //숫자 문자열과 영단어 - https://school.programmers.co.kr/learn/courses/30/lessons/81301?language=kotlin
    fun solution(s: String): Int {
        var response = s
        val hashMapOf = hashMapOf(
            Pair(0, "zero"),
            Pair(1, "one"),
            Pair(2, "two"),
            Pair(3, "three"),
            Pair(4, "four"),
            Pair(5, "five"),
            Pair(6, "six"),
            Pair(7, "seven"),
            Pair(8, "eight"),
            Pair(9, "nine"),
        )
        for (i in 0..9) {
            hashMapOf[i]?.let { response = response.replace(it, i.toString()) }
        }
        return response.toInt()
    }
}