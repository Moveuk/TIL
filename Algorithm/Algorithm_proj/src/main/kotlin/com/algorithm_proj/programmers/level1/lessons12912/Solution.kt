package com.algorithm_proj.programmers.level1.lessons12912

class Solution {
    //두 정수 사이의 합 - https://school.programmers.co.kr/learn/courses/30/lessons/12912
    fun solution(a: Int, b: Int): Long {
        var answer: Long = 0
        var tmpA = a
        var tmpB = b
        if (tmpA > tmpB) {
            val temp = tmpA
            tmpA = tmpB
            tmpB = temp
        }
        for (i in tmpA until tmpB + 1) {
            answer += i.toLong()
        }
        return answer
    }
}