package com.algorithm_proj.programmers.level1.lessons140108

class Solution {
    //문자열 나누기 - https://school.programmers.co.kr/learn/courses/30/lessons/140108
    fun solution(s: String): Int {
        val arrayDeque = ArrayDeque<Char>()
        var firstLetter: Char = s[0]
        var count = intArrayOf(0, 0)
        val list = ArrayList<String>()
        val charArray = s.toCharArray()

        for (index in 0..charArray.size - 1) {
            if (arrayDeque.isEmpty()) firstLetter = charArray[index]
            arrayDeque.add(charArray[index])
            if (charArray[index] != firstLetter) count[0]++
            if (charArray[index] == firstLetter) count[1]++
            if (count[0] == count[1]) {
                val sb = StringBuilder()
                for (index in 1..arrayDeque.size) {
                    val removeFirst = arrayDeque.removeFirst()
                    sb.append(removeFirst)
                }
                list.add(sb.toString())
                count = intArrayOf(0, 0)
                arrayDeque.clear()
            }
            if (charArray.size == index + 1 && arrayDeque.isNotEmpty()) {
                val sb = StringBuilder()
                for (index in 1..arrayDeque.size) {
                    val removeFirst = arrayDeque.removeFirst()
                    sb.append(removeFirst)
                }
                list.add(sb.toString())
            }
        }
        return list.size
    }
    //    fun solution(s: String): Int {
    //        var answer: Int = 0
    //
    //        val stack = mutableListOf<Char>()
    //
    //        s.forEach {
    //            if (stack.isEmpty()) {
    //                answer++
    //                stack.add(it)
    //            } else if (stack.first() == it) {
    //                stack.add(it)
    //            } else {
    //                stack.removeFirst()
    //            }
    //        }
    //
    //        return answer
    //    }
}