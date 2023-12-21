package com.algorithm_proj.programmers.level1.lessons42748

class Solution {
    //K번째수 - https://school.programmers.co.kr/learn/courses/30/lessons/42748?language=kotlin
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        val answer = IntArray(commands.size)

        for (commandsIndex in commands.indices) {
            answer[commandsIndex] = array.filterIndexed { index, i ->
                (commands[commandsIndex][0] - 1 <= index) && (index <= commands[commandsIndex][1] - 1)
            }.sorted()[commands[commandsIndex][2] - 1]
        }
        return answer
    }
}