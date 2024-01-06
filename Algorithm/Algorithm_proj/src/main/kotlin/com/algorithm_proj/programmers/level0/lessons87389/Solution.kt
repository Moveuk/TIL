package com.algorithm_proj.programmers.level0.lessons87389

class Solution {
    //나머지가 1이 되는 수 찾기 - https://school.programmers.co.kr/learn/courses/30/lessons/87389
    fun solution(n: Int): Int {
        return IntArray(n - 1) { it + 2 }.first { n % it == 1 }
    }
}