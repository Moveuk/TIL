package com.algorithm_proj.programmers.level1.lessons12918

class Solution {
    //문자열 다루기 기본 - https://school.programmers.co.kr/learn/courses/30/lessons/12918
    fun solution(s: String): Boolean {
        var answer = true
        try {
            s.toInt() //숫자확인 아닐시 NumberFormatException 터짐.
            if(s.length != 4 && s.length != 6) throw NumberFormatException()
        } catch (e: NumberFormatException) {
            return false
        }
        return answer
    }
}