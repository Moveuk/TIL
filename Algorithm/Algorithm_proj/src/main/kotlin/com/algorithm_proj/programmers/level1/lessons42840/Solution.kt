package com.algorithm_proj.programmers.level1.lessons42840

class Solution {
    //모의고사 - https://school.programmers.co.kr/learn/courses/30/lessons/42840?language=kotlin
    fun solution(answers: IntArray): IntArray {
        var result = intArrayOf()
        val person1 = intArrayOf(1, 2, 3, 4, 5)
        val person2 = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)
        val person3 = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
        var correctCount1 = 0
        var correctCount2 = 0
        var correctCount3 = 0

        answers.forEachIndexed { index, answer ->
            run {
                if (answer == person1[index % person1.size]) correctCount1++
                if (answer == person2[index % person2.size]) correctCount2++
                if (answer == person3[index % person3.size]) correctCount3++
            }
        }

        val counts = intArrayOf(correctCount1, correctCount2, correctCount3)
        val max = counts.maxOrNull()

        counts.forEachIndexed { index, i -> if (i == max) result = result.plus(index + 1) }
        return result.sortedArray()
    }
}