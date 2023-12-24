package com.algorithm_proj.programmers.level1.lessons134240

class Solution {
    //푸드 파이트 대회 - https://school.programmers.co.kr/learn/courses/30/lessons/134240
    fun solution(food: IntArray): String {
        val answer = StringBuilder()
        val halfFoodArray = food.map { foodAmount -> foodAmount / 2 }

        IntRange(1, food.size - 1).forEach { i ->
            for (foodAmount in 1..halfFoodArray[i]) {
                answer.append(i)
            }
        }
        val reverseAnswer = answer.reverse().toString()
        answer.reverse().append(0)
        answer.append(reverseAnswer)
        return answer.toString()
    }
}