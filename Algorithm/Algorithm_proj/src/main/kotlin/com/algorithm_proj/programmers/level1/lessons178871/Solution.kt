package com.algorithm_proj.programmers.level1.lessons178871

import java.util.*

class Solution {
    //달리기 경주 - https://school.programmers.co.kr/learn/courses/30/lessons/178871?language=kotlin
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        val rankAndNameMap: MutableMap<Int, String> = TreeMap()
        val nameAndRankMap: MutableMap<String, Int> = HashMap()

        players.forEachIndexed { index, it ->
            rankAndNameMap[index + 1] = it
            nameAndRankMap[it] = index + 1
        }

        callings.forEach { eachCalling ->
            //등수 확인
            val rank = nameAndRankMap[eachCalling]!!
            nameAndRankMap[eachCalling] = nameAndRankMap[eachCalling]!! - 1

            val frontRunner = rankAndNameMap[rank - 1]!!
            rankAndNameMap[rank - 1] = eachCalling
            nameAndRankMap[frontRunner] = nameAndRankMap[frontRunner]!! + 1

            rankAndNameMap[rank] = frontRunner
        }
        return rankAndNameMap.entries.map { it.value }.toTypedArray()
    }
}