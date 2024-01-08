package com.algorithm_proj.programmers.level1.lessons12932

class Solution {
    //자연수 뒤집어 배열로 만들기 - https://school.programmers.co.kr/learn/courses/30/lessons/12932
    fun solution(n: Long): IntArray {
        var varN = n
        val answer: IntArray

        var n1 = varN
        var index = 0
        while (n1 != 0L) {
            n1 /= 10L
            index++
        }

        answer = IntArray(index)
        for (i in 0 until index) {
            answer[i] = (varN % 10).toInt()
            varN /= 10
        }
        return answer
    }
}