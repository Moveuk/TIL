package com.algorithm_proj.programmers.level1.lessons142086

import java.util.*

class Solution {
    //가장 가까운 같은 글자 - https://school.programmers.co.kr/learn/courses/30/lessons/142086
    fun solution(s: String): IntArray {
        val answerList = ArrayList<Int>()
        val charMap = TreeMap<Int, Char>()

        IntRange(0, s.length - 1).forEach { i -> charMap[i] = s[i] }
        s.forEachIndexed { index, char ->
            val filtered = charMap.filter { it.key < index }
                .filter { char == it.value }
            val latestCharIndex = if (filtered.isEmpty()) -1
            else filtered.maxOf { entry -> entry.key }
            if (latestCharIndex == -1) answerList.add(latestCharIndex)
            else answerList.add(index - latestCharIndex)
        }

        //1. 원시코드로 풀려고 했다가 오히려 반례 찾기가 까다로워서
        //2. map과 stream 사용해서 풀이함.
        return answerList.toIntArray()
    }
}