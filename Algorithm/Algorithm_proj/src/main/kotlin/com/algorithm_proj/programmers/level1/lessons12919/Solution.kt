package com.algorithm_proj.programmers.level1.lessons12919


class Solution {
    //서울에서 김서방 찾기 - https://school.programmers.co.kr/learn/courses/30/lessons/12919
    fun solution(seoul: Array<String>): String {
        var answer = ""
        val indexOfKim = seoul.indexOfFirst { it == "Kim" }
        answer = "김서방은 ${indexOfKim}에 있다"
        return answer
    }
}