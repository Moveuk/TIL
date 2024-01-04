package com.algorithm_proj.programmers.level0.lessons12931

class Solution {
    //자릿수 더하기 - https://school.programmers.co.kr/learn/courses/30/lessons/12931?language=kotlin
    fun solution(n: Int): Int {
        var answer = 0
        var temp = n
        while (temp != 0) {
            answer += temp % 10
            temp /= 10
        }
        return answer
        //n.toString().toSingleDigitList().sum()
    }
}
