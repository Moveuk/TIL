package com.algorithm_proj.programmers.level1.lessons12954

class Solution {
    //x만큼 간격이 있는 n개의 숫자 - https://school.programmers.co.kr/learn/courses/30/lessons/12954
    fun solution(x: Int, n: Int): LongArray {
        return LongArray(n){(it + 1L) * x}
    }
}