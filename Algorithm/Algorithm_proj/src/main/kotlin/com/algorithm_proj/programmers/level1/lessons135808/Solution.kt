package com.algorithm_proj.programmers.level1.lessons135808

class Solution {
    //과일 장수 - https://school.programmers.co.kr/learn/courses/30/lessons/135808?language=kotlin
    fun solution(k: Int, m: Int, score: IntArray): Int {
        var answer: Int = 0
        var copyOfScore = score.sortedArrayDescending()

        val eachBoxMinIndex = IntArray(score.size / m) { i -> (i + 1) * m - 1 }
        answer = eachBoxMinIndex.fold(0){acc, i -> acc + copyOfScore[i] * m}

        return answer
    }
}