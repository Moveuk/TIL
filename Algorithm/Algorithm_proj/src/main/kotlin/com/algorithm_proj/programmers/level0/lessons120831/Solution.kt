package com.algorithm_proj.programmers.level0.lessons120831

class Solution {
    //짝수의 합 - https://school.programmers.co.kr/learn/courses/30/lessons/120831
    fun solution(n: Int): Int {
        return IntArray(n/2){index -> (index + 1) * 2}.sum()
    }
}