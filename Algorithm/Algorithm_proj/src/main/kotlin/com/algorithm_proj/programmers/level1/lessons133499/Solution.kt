package com.algorithm_proj.programmers.level1.lessons133499

class Solution {
    //옹알이 (2) - https://school.programmers.co.kr/learn/courses/30/lessons/133499?language=kotlin
    fun solution(babbling: Array<String>): Int {
        var answer = 0
        var str: String
        for (s in babbling) {
            str = s
            str = str.replace("ayaaya|yeye|woowoo|mama".toRegex(), " ")
            str = str.replace("aya|ye|woo|ma".toRegex(), "")
            if (str == "") answer++
        }
        return answer
    }
}