package com.algorithm_proj.programmers.level2.lessons87946

import kotlin.math.max

class Solution {
    //피로도 - https://school.programmers.co.kr/learn/courses/30/lessons/87946
    private lateinit var visited: Array<Boolean>
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        visited = Array(dungeons.size) { false }

        return go(k, dungeons);
    }

    private fun go(k: Int, dungeons: Array<IntArray>): Int {
        var ans = 0

        for (i in dungeons.indices) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true
                ans = max(ans.toDouble(), go(k - dungeons[i][1], dungeons).toDouble()).toInt()
                visited[i] = false
            }
        }

        return max(ans.toDouble(), adventure(visited).toDouble()).toInt()
    }

    private fun adventure(isVisited: Array<Boolean>): Int {
        var count = 0
        for (v in isVisited) {
            if (v) count++
        }
        return count
    }
}