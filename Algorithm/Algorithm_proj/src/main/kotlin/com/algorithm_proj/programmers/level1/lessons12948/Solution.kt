package com.algorithm_proj.programmers.level1.lessons12948

class Solution {
    //핸드폰 번호 가리기 - https://school.programmers.co.kr/learn/courses/30/lessons/12948
    fun solution(phone_number: String): String = phone_number.replace(".(?=.{4})".toRegex(), "*")
}