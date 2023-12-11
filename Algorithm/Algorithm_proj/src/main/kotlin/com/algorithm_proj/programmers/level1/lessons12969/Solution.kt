package com.algorithm_proj.programmers.level1.lessons12969

class Solution {
    //직사각형 별찍기 - https://school.programmers.co.kr/learn/courses/30/lessons/12969?language=kotlin
    fun solution(col: String, row: String){
        val star = "*"
        val rowString = StringBuilder()
        for (i in 1..col.toInt()){
            rowString.append(star)
        }
        for (i in 1..row.toInt()){
            println(rowString.toString())
        }
    }
}
fun main() {
    //프로그래머스 제출용
    val input = readLine()!!
    val col = input.split(" ").get(0).toInt()
    val row = input.split(" ").get(1).toInt()
    val star = "*"
    val rowString = StringBuilder()
    for (i in 1..col){
        rowString.append(star)
    }
    for (i in 1..row){
        println(rowString.toString())
    }
}