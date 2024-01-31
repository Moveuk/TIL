package com.algorithm_proj.programmers.level1.lessons12939

class Solution {
    //최댓값과 최솟값 - https://school.programmers.co.kr/learn/courses/30/lessons/12939
    fun solution(s: String): String {
        return s.split(" ").map { it.toInt() }.let { "${it.min()} ${it.max()}" }
    }
}