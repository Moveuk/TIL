package com.algorithm_proj.programmers.level1.lessons131127

class Solution {
    //할인 행사 - https://school.programmers.co.kr/learn/courses/30/lessons/131127
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var answer = 0
        val countOfItem = number.sum()

        val hashMap = HashMap<String, Int>()
        val discountMap = HashMap<String, Int>()

        for (i in want.indices) {
            hashMap[want[i]] = number[i]
        }

        for (i in 0 until discount.size - countOfItem + 1) {
            for (j in i until i + countOfItem) {
                discountMap[discount[j]] = discountMap.getOrDefault(discount[j], 0) + 1
            }
            //비교
            val flag = hashMap.keys.stream().allMatch { y: String ->
                hashMap[y] == discountMap[y]
            }
            if (flag) {
                answer += 1
            }
            discountMap.clear()
        }

        return answer
    }
}