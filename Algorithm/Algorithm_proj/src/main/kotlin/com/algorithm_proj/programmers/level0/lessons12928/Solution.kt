package com.algorithm_proj.programmers.level0.lessons12928

import kotlin.math.sqrt

class Solution {
    //약수의 합 - https://school.programmers.co.kr/learn/courses/30/lessons/12928?language=kotlin
    fun solution(n: Int): Int {
        var answer = 0
        for (i in 1..sqrt(n.toDouble()).toInt()) {
            if (i * i == n) answer += i
            else if (n % i == 0) answer += i + (n / i)
        }
        return answer
    }
}
