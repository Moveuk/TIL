package com.algorithm_proj.programmers.level1.lessons12917

class Solution {
    //문자열 내림차순으로 배치하기 - https://school.programmers.co.kr/learn/courses/30/lessons/12917
    fun solution(s: String): String {
        val answer = StringBuilder()
        s.chars().sorted().mapToObj { c -> Char(c).toString() }.forEach{answer.append(it)}
        return answer.reverse().toString()
        // 1. 자체 sort
        //  String(s.toCharArray().sortedArrayDescending())
        // 2. Comparator 작성
        //  s.toCharArray()
        //            .sortedWith(Comparator { a, b -> b - a })
        //            .joinToString("")
    }
}