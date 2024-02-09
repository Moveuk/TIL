package com.algorithm_proj.programmers.level1.lessons42747


class Solution {
    //H-Index - https://school.programmers.co.kr/learn/courses/30/lessons/42747
    fun solution(citations: IntArray): Int {
        var answer = 0
        val sortedCitations = citations.map { x: Int -> -x }.sorted().map { x: Int -> -x }

        for (i in citations.indices) {
            var count = 0
            for (citation in sortedCitations) {
                if (i + 1 <= citation) {
                    count++
                }
            }
            if (i + 1 in answer..count && citations.size - count <= i + 1) {
                answer = i + 1
            }
        }

        return answer
    }
}