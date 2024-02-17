package com.algorithm_proj.programmers.level2.lessons154539

import java.util.*

class Solution {
    //뒤에 있는 큰 수 찾기 - https://school.programmers.co.kr/learn/courses/30/lessons/154539
    fun solution(numbers: IntArray): IntArray {
        // number index 정보를 담을 Stack 생성
        val stack = Stack<Int>()
        val answer = IntArray(numbers.size)

        stack.push(0)

        for (i in 1 until numbers.size) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i]
            }
            stack.push(i)
        }
        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1
        }

        return answer
    }
}