package com.algorithm_proj.programmers.level2.lessons12985

class Solution {
    //예상 대진표 - https://school.programmers.co.kr/learn/courses/30/lessons/12985
    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 0
        var atmp = a
        var btmp = b

        while (atmp != btmp) {
            atmp = (atmp + 1) / 2
            btmp = (btmp + 1) / 2
            answer++
        }

        return answer
    }
}