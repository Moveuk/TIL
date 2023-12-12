package com.algorithm_proj.programmers.level1.lessons12940

class Solution {
    //최대공약수와 최소공배수 - https://school.programmers.co.kr/learn/courses/30/lessons/12940?language=kotlin
    fun solution(n: Int, m: Int): IntArray {
        var answer = IntArray(2)
        answer[0] = gcd(n, m)
        answer[1] = n * m /answer[0]
        return answer
    }

    fun gcd(n: Int, m: Int) : Int {
        return if (m == 0) {
            n
        } else {
            gcd(m, n % m)
        }
    }
}