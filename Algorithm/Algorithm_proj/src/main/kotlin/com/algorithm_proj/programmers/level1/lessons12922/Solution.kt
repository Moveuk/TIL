package com.algorithm_proj.programmers.level1.lessons12922

class Solution {
    //수박수박수박수박수박수? - https://school.programmers.co.kr/learn/courses/30/lessons/12922?language=kotlin
        fun solution(n: Int): String {
            var answer = ""
            for (i in 1..n) {
                answer += if (i % 2 == 1) "수" else "박"
            }
            return answer
        }
}