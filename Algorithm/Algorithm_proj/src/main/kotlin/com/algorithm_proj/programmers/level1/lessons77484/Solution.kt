package com.algorithm_proj.programmers.level1.lessons77484

class Solution {
    //로또의 최고 순위와 최저 순위 - https://school.programmers.co.kr/learn/courses/30/lessons/77484?language=kotlin
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        var answer: IntArray = intArrayOf(0, 0)
        //돌면서 같은 갯수 확인해서 0만큽 더하면 최대 같은 갯수가 최저 등수 처리
        for (lotto in lottos) {
            for (win_num in win_nums) {
                if (lotto == win_num) {
                    answer[0]--
                    answer[1]--
                }
            }
            if (lotto == 0) {
                answer[0]--
            }
        }
        answer[0] += 7
        answer[1] += 7
        if (answer[0] > 6) {answer[0] = 6}
        if (answer[1] > 6) {answer[1] = 6}

        return answer
    }
}