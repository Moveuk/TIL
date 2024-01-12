package com.algorithm_proj.programmers.level1.lessons155652

class Solution {
    //둘만의 암호 - https://school.programmers.co.kr/learn/courses/30/lessons/155652
    fun solution(s: String, skip: String, index: Int): String {
        var answer = StringBuilder()
        val sToCharList = s.toCharArray().toList()
        val alphabetToCharList = "abcdefghijklmnopqrstuvwxyz".toCharArray().toMutableList()
        val skipToCharList = skip.toCharArray().toMutableList()

        for (i in skipToCharList.indices) {
            alphabetToCharList.remove(skipToCharList[i])
        }

        sToCharList.forEachIndexed { ind: Int, c: Char ->
            val indexOf = alphabetToCharList.indexOf(c)
            val addIndex =
                if (indexOf + index >= alphabetToCharList.size) (indexOf + index) % alphabetToCharList.size
                else indexOf + index
            answer.append(alphabetToCharList[addIndex])
        }

        return answer.toString()
    }
}