package com.algorithm_proj.programmers.level2.lessons42578

class Solution {
    //의상 - https://school.programmers.co.kr/learn/courses/30/lessons/42578
    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 1
        //headgear, eyewear, face,
        val counts: MutableMap<String, Int> = HashMap()

        //종류 카테고리화
        for (set in clothes) {
            counts[set[1]] = counts.getOrDefault(set[1], 0) + 1
        }

        val kinds: Set<String> = counts.keys
        kinds.forEach { x: String ->
            answer *= (counts[x]!! + 1)
        }

        return answer - 1
    }
}