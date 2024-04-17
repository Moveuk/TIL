package com.algorithm_proj.programmers.level2.lessons131701


class Solution {
    //연속 부분 수열 합의 개수 - https://school.programmers.co.kr/learn/courses/30/lessons/131701
    fun solution(elements: IntArray): Int {
        val set: MutableSet<Int> = HashSet()

        for (i in elements.indices) {
            var sum = 0
            for (j in elements.indices) {
                sum += elements[(i + j) % elements.size]
                set.add(sum)
            }
        }

        return set.size
    }
}