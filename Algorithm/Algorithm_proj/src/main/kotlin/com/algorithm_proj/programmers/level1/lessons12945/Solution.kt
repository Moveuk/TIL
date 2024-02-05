package com.algorithm_proj.programmers.level1.lessons12945

class Solution {
    //피보나치 수 - https://school.programmers.co.kr/learn/courses/30/lessons/12945
    fun solution(n: Int): Int {
        var ans = Array(n+1) { i -> 0 }
        ans[1] = 1
        for(i in 2..n) ans[i] = (ans[i-1] + ans[i-2])%1234567
        return ans[n]
    }
}