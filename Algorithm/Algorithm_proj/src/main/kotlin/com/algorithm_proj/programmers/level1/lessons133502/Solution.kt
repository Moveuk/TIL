package com.algorithm_proj.programmers.level1.lessons133502

class Solution {
    //햄버거 만들기 - https://school.programmers.co.kr/learn/courses/30/lessons/133502
    fun solution(ingredient: IntArray): Int {
        var answer: Int = 0
        val sb = StringBuilder()

        for (burgerIng in ingredient) {
            sb.append(burgerIng)
            if (sb.length >= 4 && sb.contains("1231")){
                sb.setLength(sb.length - 4)
                answer++
            }
        }

        return answer
    }
}