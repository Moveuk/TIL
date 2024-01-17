package com.algorithm_proj.programmers.level1.lessons161990

import kotlin.math.max
import kotlin.math.min

class Solution {
    //바탕화면 정리 - https://school.programmers.co.kr/learn/courses/30/lessons/161990?language=kotlin
    fun solution(wallpaper: Array<String>): IntArray {
        var lux = -1
        var luy = -1
        var rdx = -1
        var rdy = -1


        wallpaper.forEachIndexed { index, s ->
            val sharpFirstIndex = s.indexOfFirst { c -> c == '#' }
            val sharpLastIndex = s.indexOfLast { c -> c == '#' }

            if (lux == -1 && sharpFirstIndex != -1) lux = index
            luy = if (luy == -1 && sharpFirstIndex != -1) {
                sharpFirstIndex
            } else if (sharpFirstIndex != -1)  {
                min(luy, sharpFirstIndex)
            } else {
                luy
            }
            if (s.contains("#")) rdx = index + 1
            rdy = if (rdy == -1 && sharpLastIndex != -1) {
                sharpLastIndex + 1
            } else if (sharpLastIndex != -1)  {
                max(rdy, sharpLastIndex + 1)
            } else {
                rdy
            }
        }


        var answer: IntArray = intArrayOf(lux, luy, rdx, rdy)

        return answer
    }
}