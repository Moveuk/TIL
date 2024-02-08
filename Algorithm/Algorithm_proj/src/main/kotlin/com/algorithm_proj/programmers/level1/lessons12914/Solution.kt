package com.algorithm_proj.programmers.level1.lessons12914

class Solution {
    //멀리 뛰기 - https://school.programmers.co.kr/learn/courses/30/lessons/12914
    fun solution(n: Int): Long {
        val cache = LongArray(n + 1)
        cache[0] = 1L
        cache[1] = 1L
        for (i in 0..n) {
            if (i >= 2 && cache[i] == 0L) {
                val sum = cache[i - 2] + cache[i - 1]
                cache[i] = sum % 1234567L
            }
        }
        return cache[n]
    }
}