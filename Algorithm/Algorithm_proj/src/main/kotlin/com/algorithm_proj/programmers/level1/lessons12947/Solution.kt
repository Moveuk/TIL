package com.algorithm_proj.programmers.level1.lessons12947

class Solution {
    //하샤드 수 - https://school.programmers.co.kr/learn/courses/30/lessons/12947
    fun solution(x: Int): Boolean {
        var answer = true
        var sum = 0

        val hasad: Int = x
        var tmp = x

        while (tmp != 0) {
            sum += tmp % 10
            tmp /= 10
        }

        answer = hasad % sum == 0
        return answer
    }
}