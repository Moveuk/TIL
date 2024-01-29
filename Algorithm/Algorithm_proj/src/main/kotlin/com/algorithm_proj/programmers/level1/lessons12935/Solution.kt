package com.algorithm_proj.programmers.level1.lessons12935

class Solution {
    //제일 작은 수 제거하기 - https://school.programmers.co.kr/learn/courses/30/lessons/12935?language=kotlin
    fun solution(arr: IntArray): IntArray {
        val min = arr.minByOrNull { i->i }

        val removedArr = arr.toMutableList()

        removedArr.remove(min)

        if (removedArr.size == 0) removedArr.add(-1)

        return removedArr.toIntArray()
    }
}