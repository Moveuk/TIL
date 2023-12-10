package com.algorithm_proj.programmers.level1.lessons82612

class Solution {
    //부족한 금액 계산하기 - https://school.programmers.co.kr/learn/courses/30/lessons/82612
    fun solution(price: Int, money: Int, count: Int): Long {
        var answer: Long = (price.toLong() * (count * (count + 1) / 2).toLong() - money.toLong())
        if (answer <= 0) answer = 0
//        answer = IntArray(count) { i -> i + 1 }.fold(0,) { total, i ->total + i * price} - money
//        println(answer)
        // 자연수 거듭제곱의 합
        // 시그마 k 1~n 일때 = n*(n+1)/2 임
        return answer
    }
}