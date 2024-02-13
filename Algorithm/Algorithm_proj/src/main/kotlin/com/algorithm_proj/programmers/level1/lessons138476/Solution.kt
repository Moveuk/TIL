package com.algorithm_proj.programmers.level1.lessons138476

import java.util.*

class Solution {
    //귤 고르기 - https://school.programmers.co.kr/learn/courses/30/lessons/138476?language=kotlin
    fun solution(k: Int, tangerine: IntArray): Int {
        var ktemp = k
        var answer = 0

        val map: MutableMap<Int, Int> = HashMap()
        for (sizeOfTang in tangerine) {
            map[sizeOfTang] = map.getOrDefault(sizeOfTang, 0) + 1
        }

        val mapList: List<Map.Entry<Int, Int>> = LinkedList<Map.Entry<Int, Int>>(map.entries)

        val sortedList: List<Map.Entry<Int, Int>> = mapList.sortedWith { i1: Map.Entry<Int, Int?>, i2: Map.Entry<Int, Int?> ->
            map[i2.key]!! - map[i1.key]!!
        }

        for ((_, value) in sortedList) {
            answer++
            ktemp -= value
            if (ktemp <= 0) {
                break
            }
        }

        return answer
    }

    fun solution2(k: Int, tangerine: IntArray): Int {
        var answer: Int = 0
        var limit = 0
        tangerine.groupBy { it }.toList().sortedByDescending { it.second.size }.forEach{
            if(limit >= k){
                return answer
            }
            limit += it.second.size
            answer++
        }

        return answer
    }
}