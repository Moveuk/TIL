package com.algorithm_proj.programmers.level1.lessons138477

class Solution {
    //명예의 전당 (1) - https://school.programmers.co.kr/learn/courses/30/lessons/138477
    fun solution(k: Int, score: IntArray): IntArray {
        var answer: IntArray = IntArray(score.size)
        var rank: IntArray = IntArray(k)
        score.forEachIndexed { index, i ->
            rank = rank.plus(i).sortedArrayDescending().copyOfRange(0, k + 1)

            if (index >= k - 1) {
                answer[index] = rank[k - 1]
            } else {
                answer[index] = rank[index]
            }
        }
        return answer
    }
}