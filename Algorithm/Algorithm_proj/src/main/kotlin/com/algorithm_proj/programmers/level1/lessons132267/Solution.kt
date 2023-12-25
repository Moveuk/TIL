package com.algorithm_proj.programmers.level1.lessons132267

class Solution {
    //콜라 문제 - https://school.programmers.co.kr/learn/courses/30/lessons/132267
    fun solution(a: Int, b: Int, n: Int): Int {
        var answer: Int = 0
        var nTemp = n

        while (true) {
            val divisor = nTemp / a
            val remainder = nTemp % a
            val changedAmount = divisor * b
            answer += changedAmount
            nTemp = remainder + changedAmount
            if (nTemp < a) break
        }
        return answer
    }
}