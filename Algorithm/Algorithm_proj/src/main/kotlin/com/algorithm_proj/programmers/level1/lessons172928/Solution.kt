package com.algorithm_proj.programmers.level1.lessons172928

import kotlin.math.max
import kotlin.math.min

class Solution {
    //공원 산책 - https://school.programmers.co.kr/learn/courses/30/lessons/172928
    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        var answer: IntArray = intArrayOf(0, 0)
        val (parkXMaxSize, parkYMaxSize) = intArrayOf(park[0].length - 1, park.size - 1)

        run breaker@{
            park.forEachIndexed { yIndex, row ->
                if (row.contains("S")) {
                    val xIndex = row.toCharArray().indexOf('S')
                    answer[0] = yIndex
                    answer[1] = xIndex
                    return@breaker
                }
            }
        }

        routes.forEach { directionDistance ->
            val split = directionDistance.split(" ")
            val direction = split[0]
            val distance =
                if (direction == "W" || direction == "N") split[1].toInt() * -1
                else split[1].toInt()

            when (direction) {
                "E", "W" -> {
                    val (currentPositionY, currentPositionX) = answer
                    val currentRow = park[currentPositionY]
                    val eachSpaceArray = currentRow.toCharArray()
                    val finalDestination = currentPositionX + distance
                    if (finalDestination !in 0..parkXMaxSize) return@forEach
                    val min = min(currentPositionX, finalDestination)
                    val max = max(currentPositionX , finalDestination)
                    println("min,max: $min, $max / leng: ${eachSpaceArray.size}")
                    for (xIndex in min..max) {
                        if (eachSpaceArray[xIndex] == 'X') return@forEach
                    }
                    answer[1] += distance
                }

                "N", "S" -> {
                    val (currentPositionY, currentPositionX) = answer
                    val finalDestination = currentPositionY + distance
                    if (finalDestination !in 0..parkYMaxSize) return@forEach
                    val min = min(currentPositionY , finalDestination)
                    val max = max(currentPositionY , finalDestination)
                    for (yIndex in min..max) {
                        val eachRow = park[yIndex]
                        val eachSpaceArray = eachRow.toCharArray()
                        if (eachSpaceArray[currentPositionX] == 'X') return@forEach
                    }
                    answer[0] += distance
                }

            }
        }
        return answer
    }
    //    private fun findStart(park: Array<String>): MutableList<Int> {
    //        for (i in park.indices)
    //            for (j in park[i].indices)
    //                if (park[i][j] == 'S')
    //                    return mutableListOf(i, j)
    //        return mutableListOf(0, 0)
    //    }
    //
    //    fun solution(park: Array<String>, routes: Array<String>): IntArray {
    //        val directions = mapOf('E' to (0 to 1), 'W' to (0 to -1), 'N' to (-1 to 0), 'S' to (1 to 0))
    //        return routes.map { it[0] to it.drop(2).toInt() }
    //                .fold(findStart(park)) { pos, (direction, distance) ->
    //                    val prevPos = pos.toMutableList()
    //                    val nextPos = pos.toMutableList()
    //                    repeat(distance) {
    //                        nextPos[0] += directions[direction]!!.first
    //                        nextPos[1] += directions[direction]!!.second
    //                        if (!(0 <= nextPos[0] && nextPos[0] < park.size && 0 <= nextPos[1] && nextPos[1] < park[0].length && park[nextPos[0]][nextPos[1]] != 'X'))
    //                            return@fold prevPos
    //                    }
    //                    return@fold nextPos
    //                }.toIntArray()
    //    }
}