package com.algorithm_proj.programmers.level1.lessons12903

class Solution {
    //가운데 글자 가져오기 - https://school.programmers.co.kr/learn/courses/30/lessons/12903
    fun solution(s: String): String {
        val length = s.length

        return if (length % 2 == 1) {
            s.substring(s.length / 2, s.length / 2 + 1)
        } else {
            s.substring(s.length / 2 - 1, s.length / 2 + 1)
        }
    }
}