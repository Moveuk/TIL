package com.algorithm_proj.programmers.level1.lessons12926

class Solution {
    //시저 암호 - https://school.programmers.co.kr/learn/courses/30/lessons/12926?language=kotlin
    fun solution(s: String, n: Int): String {
        val answer = StringBuilder()
        s.chars().forEach { c ->
            val result : Char =  if (c.toChar().isLowerCase()) {
                var temp = (c + n).toChar()
                if ('z' < temp ) temp -= 26
                temp
            } else if (c.toChar().isUpperCase()) {
                var temp = (c + n).toChar()
                if ('Z' < temp ) temp -= 26
                temp
            } else {
                c.toChar()
            }
            answer.append(result)
        }
        return answer.toString()
    }
}