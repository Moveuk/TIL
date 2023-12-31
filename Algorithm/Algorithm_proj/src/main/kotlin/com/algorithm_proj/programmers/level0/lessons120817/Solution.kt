package com.algorithm_proj.programmers.level0.lessons120817

class Solution {
    //배열의 평균값 - https://school.programmers.co.kr/learn/courses/30/lessons/120817
    fun solution(numbers: IntArray): Double {
        return numbers.sum().div(numbers.size.toDouble())
        // numbers.average()
    }
}