package com.algorithm_proj.programmers.level1.lessons42862


class Solution {
    //체육복 - https://school.programmers.co.kr/learn/courses/30/lessons/42862
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var max: Int = n - lost.size // 기본적으로 수업에 참여할 수 있는 학생 수

        lost.sort()
        reserve.sort()

        for (i in lost.indices) {
            for (j in reserve.indices) {
                if (lost[i] == reserve[j]) {
                    max++
                    lost[i] = 0
                    reserve[j] = 0
                    break
                }
            }
        }

        for (l in lost) {
            if (l == 0) continue
            for (i in reserve.indices) {
                if (reserve[i] == 0) continue

                val prev = l - 1 // 이전 번호
                val next = l + 1 // 다음 번호

                if (prev == reserve[i] || next == reserve[i]) {
                    max++
                    reserve[i] = 0
                    break
                }
            }
        }
        return max
    }
}