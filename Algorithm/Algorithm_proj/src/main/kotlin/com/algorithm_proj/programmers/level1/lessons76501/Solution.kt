package com.algorithm_proj.programmers.level1.lessons76501

class Solution {
    //음양 더하기 - https://school.programmers.co.kr/learn/courses/30/lessons/76501
    fun solution(absolutes: IntArray, signs: BooleanArray): Int {
        var answer = 0
        for (i in absolutes.indices) {
            answer += if (signs[i]) absolutes[i] else -1 * absolutes[i]
        }
        return answer
    }
}