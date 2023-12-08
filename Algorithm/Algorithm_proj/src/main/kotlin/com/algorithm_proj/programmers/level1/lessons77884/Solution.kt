package com.algorithm_proj.programmers.level1.lessons77884

class Solution {
    //약수의 개수와 덧셈 - https://school.programmers.co.kr/learn/courses/30/lessons/77884?language=kotlin
    fun solution(left: Int, right: Int): Int {
        val answer: Int = IntArray(right - left + 1) { i -> left + i }.fold(0) { total, i ->
            val isEvenOfDivided = IntArray(i) { j -> j + 1 }.count { k -> i % k == 0 } % 2 == 0
            if (isEvenOfDivided) total + i
            else total - i
        }
        // 심플 답안
        // (left..right).map { i -> if ((1..i).filter { i % it == 0 }.size % 2 == 0) i else -i }.sum()
        // 접근은 비슷했으나 코틀린 문법을 모르는게 큰 것 같다. (start..end)
        return answer
    }
}