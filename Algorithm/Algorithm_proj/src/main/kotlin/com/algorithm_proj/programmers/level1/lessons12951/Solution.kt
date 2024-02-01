package com.algorithm_proj.programmers.level1.lessons12951

class Solution {
    //JadenCase 문자열 만들기 - https://school.programmers.co.kr/learn/courses/30/lessons/12951
    fun solution(s: String): String =
        s.split(" ").map {
            var s = it
            if (it != "") {
                s = it[0].toUpperCase() + it.substring(1..it.length - 1).lowercase()
            }
            s
        }
            .joinToString(" ")
    // s.toLowerCase().split(" ").map {
    //                it.capitalize()
    //            }.joinToString(" ")
}