package com.algorithm_proj.programmers.level1.lessons68935

class Solution {
    //3진법 뒤집기 - https://school.programmers.co.kr/learn/courses/30/lessons/68935?language=kotlin
    fun solution(n: Int): Int {
        val sb = StringBuilder()
        var container = n
        while(container > 0){
            sb.append(container % 3)
            container /= 3
        }

        return Integer.parseInt(sb.toString(),3)
    }
}