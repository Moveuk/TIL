package com.algorithm_proj.programmers.level1.lessons12915

class Solution {
    //문자열 내 마음대로 정렬하기 - https://school.programmers.co.kr/learn/courses/30/lessons/12915?language=kotlin
    fun solution(strings: Array<String>, n: Int): Array<String> {
        var answer = strings

        answer.sortWith(kotlin.Comparator { s1, s2 ->
            if (s1[n] > s2[n]) 1
            else if (s1[n] == s2[n]) s1.compareTo(s2)
            else -1
        })

        return answer
    }
}