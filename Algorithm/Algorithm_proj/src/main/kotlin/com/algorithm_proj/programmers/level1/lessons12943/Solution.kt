package com.algorithm_proj.programmers.level1.lessons12943

class Solution {
    //콜라츠 추측 - https://school.programmers.co.kr/learn/courses/30/lessons/12943
    fun solution(num: Int): Int {
        var answer = 0
        var index = 0
        var tmpNum = num
        while (index < 500) {
            if (tmpNum == 1) {
                answer = index
                break
            } else if (tmpNum % 2 == 0) {
                tmpNum /= 2
            } else if (tmpNum % 2 == 1) {
                tmpNum = tmpNum * 3 + 1
            } else if (index == 499) {
                answer = -1
                break
            }
            index++
        }
        return answer
    }
}