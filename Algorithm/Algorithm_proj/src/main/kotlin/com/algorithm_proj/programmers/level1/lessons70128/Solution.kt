package com.algorithm_proj.programmers.level1.lessons70128

class Solution {
    //내적 - https://school.programmers.co.kr/learn/courses/30/lessons/70128
    fun solution(a: IntArray, b: IntArray): Int {
        val answer: Int = IntArray(a.size, { i -> i }).fold(0) { product, i -> product + a[i] * b[i] }

        // 다른 풀이
        // zip사용 : a.zip(b).map { it.first * it.second }.sum()
        // Map도 Indexed가 있음 : Int = a.mapIndexed { index, it -> it * b[index] }.sum()
        return answer
    }
}