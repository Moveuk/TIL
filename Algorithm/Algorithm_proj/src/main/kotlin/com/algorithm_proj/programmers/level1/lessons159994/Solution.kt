package com.algorithm_proj.programmers.level1.lessons159994

class Solution {
    //카드 뭉치 - https://school.programmers.co.kr/learn/courses/30/lessons/159994
    fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
        var answer: String = "Yes"
        val positionArray = intArrayOf(0, 0)

        for (index in goal.indices) {
            var flagForCards1Index = true
            var flagForCards2Index = true

            // 길이 체크
            if (positionArray[0] >= cards1.size) flagForCards1Index = false
            if (positionArray[1] >= cards2.size) flagForCards2Index = false

            if (flagForCards1Index && cards1[positionArray[0]] == goal[index]) {
                positionArray[0]++
            }
            else if (flagForCards2Index && cards2[positionArray[1]] == goal[index]) {
                positionArray[1]++
            }
            else {
                answer = "No"
                break
            }
        }

        return answer
    }
}