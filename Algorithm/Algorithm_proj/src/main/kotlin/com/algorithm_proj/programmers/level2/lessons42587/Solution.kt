package com.algorithm_proj.programmers.level2.lessons42587

class Solution {
    //프로세스 - https://school.programmers.co.kr/learn/courses/30/lessons/42587
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0
        val queue = ArrayDeque<Pair<Int, Int>>()
        val findingPair = Pair(priorities[location], location)
        priorities.forEachIndexed { index, i ->
            val data = Pair(i, index)
            queue.add(data)
        }
        while (queue.isNotEmpty()) {
            val first = queue.first()
            if (queue.count { it.first > first.first } != 0) {
                queue.addLast(first)
                queue.removeFirst()
            } else {
                if (first == findingPair) break
                else {
                    queue.removeFirst()
                    answer++
                }
            }
        }

        return answer + 1
    }
}
