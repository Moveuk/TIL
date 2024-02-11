package com.algorithm_proj.programmers.level1.lessons76502

import java.util.*

class Solution {
    //괄호 회전하기 - https://school.programmers.co.kr/learn/courses/30/lessons/76502
    fun solution(s: String): Int {
        var stmp = s
        var answer = 0

        for (i in 0 until stmp.length) {
            if (isCorrectBracket(stmp)) {
                answer++
            }
            val firstChar = stmp.substring(0, 1)
            stmp = stmp.substring(1)
            stmp += firstChar
        }

        return answer
    }

    //Check the bracket
    private fun isCorrectBracket(s: String): Boolean {
        val stack = Stack<Char>()
        for (element in s) {
            val c = element
            if (c.code == 40 || c.code == 123 || c.code == 91) {
                stack.push(c)
            } else if (c.code == 41 || c.code == 125 || c.code == 93) {
                if (stack.empty()) {
                    return false
                }

                val endBracket: Char? = when (c.code) {
                    41 -> '('
                    93 -> '['
                    125 -> '{'
                    else -> null
                }

                if (stack.peek() == endBracket) {
                    stack.pop()
                } else {
                    stack.push(c)
                }
            }
        }
        return stack.empty()
    }
}