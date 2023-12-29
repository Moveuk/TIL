package com.algorithm_proj.programmers.level0.lessons120829

class Solution {
    //각도기 - https://school.programmers.co.kr/learn/courses/30/lessons/120829?language=kotlin
    fun solution(angle: Int): Int {
        return when (angle) {
            in 1..89 -> 1
            90 -> 2
            in 91..179 -> 3
            else -> 4
        }
    }
}