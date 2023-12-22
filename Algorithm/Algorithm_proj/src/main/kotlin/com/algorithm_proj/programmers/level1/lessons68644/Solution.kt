package com.algorithm_proj.programmers.level1.lessons68644

import java.util.*

class Solution {
    //두 개 뽑아서 더하기 - https://school.programmers.co.kr/learn/courses/30/lessons/68644?language=kotlin
    fun solution(numbers: IntArray): IntArray {
        val answerSet = TreeSet<Int>()
        for (outerIndex in numbers.indices) {
            for (innerIndex in outerIndex + 1..<numbers.size) {
                answerSet.add(numbers[outerIndex] + numbers[innerIndex])
            }
        }
        return answerSet.toIntArray()
        //         val list = numbers.toList()
        //        return list.withIndex().flatMap { i -> list.withIndex().map { j -> i to j } }
        //            .filter { it.first.index != it.second.index }
        //            .map { it.first.value + it.second.value }
        //            .toSortedSet()
        //            .toIntArray()
        // toSortedSet(), for문자체로 스트림으로. map 활용.
    }
}