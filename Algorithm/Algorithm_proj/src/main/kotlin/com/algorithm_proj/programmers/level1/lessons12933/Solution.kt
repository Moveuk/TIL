package com.algorithm_proj.programmers.level1.lessons12933

class Solution {
    //정수 내림차순으로 배치하기 - https://school.programmers.co.kr/learn/courses/30/lessons/12933?language=kotlin
    fun solution(n: Long): Long = n.toString().toCharArray().sorted().reversed().joinToString("").toLong()
}