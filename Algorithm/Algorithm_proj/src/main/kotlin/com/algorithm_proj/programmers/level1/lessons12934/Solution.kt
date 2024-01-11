package com.algorithm_proj.programmers.level1.lessons12934

import kotlin.math.pow
import kotlin.math.sqrt

class Solution {
    //정수 제곱근 판별 - https://school.programmers.co.kr/learn/courses/30/lessons/12934?language=kotlin
    fun solution(n: Long): Long = if (sqrt(n.toDouble()) % 1 == 0.0) ((sqrt(n.toDouble()) + 1).pow(2)).toLong() else -1L
}