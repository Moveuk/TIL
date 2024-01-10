package com.algorithm_proj.programmers.level1.lessons160586

import java.util.*
import kotlin.math.min

class Solution {
    //대충 만든 자판 - https://school.programmers.co.kr/learn/courses/30/lessons/160586
    fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
        var answer = IntArray(targets.size)
        val treeMap = TreeMap<Char, Int>()

        keymap.forEachIndexed() { keymapIndex, it ->
            it.toCharArray().forEachIndexed() { charsIndex, char ->
                treeMap[char] = min(treeMap.getOrDefault(char, 100), charsIndex + 1)
            }
        }


        targets.forEachIndexed { targetsIndex, s ->
            s.toCharArray().forEach {
                if (treeMap[it] == null) {
                    answer[targetsIndex] = 0
                    return@forEachIndexed
                }
                answer[targetsIndex] += treeMap[it]!!
            }
        }
        answer.forEachIndexed { index, it ->
            if (it == 0) answer[index] = -1
        }

        return answer
    }
    // 정리를 먼저하는게 아니고 타겟을 count로 변경.
    //    fun solution2(keymap: Array<String>, targets: Array<String>): IntArray =
    //        targets.map { str ->
    //            str.map { c -> keymap.map { it.indexOf(c) + 1 }
    //                .filterNot { it < 1 }
    //                .let { list ->
    //                    if (list.isEmpty()) -1
    //                    else list.minOf { it }
    //                }
    //            }.let { if ( it.contains(-1)) -1 else it.sum() }
    //        }.toIntArray()
}