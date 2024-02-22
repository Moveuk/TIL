package com.algorithm_proj.programmers.level2.lessons12949

class Solution {
    //행렬의 곱셈 - https://school.programmers.co.kr/learn/courses/30/lessons/12949
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        val answer = Array(arr1.size) { IntArray(arr2[0].size) }

        for (i in answer.indices) {
            for (j in answer[0].indices) {
                for (k in arr1[0].indices) {
                    answer[i][j] += arr1[i][k] * arr2[k][j]
                }
            }
        }

        return answer
    }
    //
}