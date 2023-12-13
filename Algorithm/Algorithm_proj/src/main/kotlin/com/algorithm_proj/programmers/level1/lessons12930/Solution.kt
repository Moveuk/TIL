package com.algorithm_proj.programmers.level1.lessons12930

class Solution {
    //이상한 문자 만들기 - https://school.programmers.co.kr/learn/courses/30/lessons/12930
    fun solution(s: String): String {
        var answer = ""
        s.split(" ")
            .forEachIndexed { index, str ->
                str.forEachIndexed { innerIndex, c -> answer += if (innerIndex % 2 == 0) c.uppercase() else c.lowercase() }
                answer += " "
            }
        return answer.substring(0, answer.length - 1)
        //joinToString()
        //s.split(" ").joinToString(" ") { word ->
        //    word
        //        .mapIndexed { index, char ->
        //            if (index % 2 == 0) char.toUpperCase() else char.toLowerCase()
        //        }
        //        .joinToString("")
        //}
    }
}