package com.algorithm_proj.programmers.level1.lessons136798

import java.util.*
import kotlin.math.sqrt

class Solution {
    //기사단원의 무기 - https://school.programmers.co.kr/learn/courses/30/lessons/136798?language=kotlin
    fun solution(number: Int, limit: Int, power: Int): Int {
        val powers = TreeMap<Int, Int>()
        for (int in 1..number) {
            if (powers.contains(int)) continue
            else {
                var count = 0
                for (i in 1..sqrt(int.toDouble()).toInt()) {
                    if (i * i == int) count++
                    else if (int % i == 0) count += 2
                }
                powers[int] = if (count > limit) power else count
            }
        }
        return powers.toList().sumOf { it.second }
    }
}