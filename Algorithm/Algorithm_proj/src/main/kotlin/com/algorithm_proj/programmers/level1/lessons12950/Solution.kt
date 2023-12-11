package com.algorithm_proj.programmers.level1.lessons12950

class Solution {
    //행렬의 덧셈 - https://school.programmers.co.kr/learn/courses/30/lessons/12950?language=kotlin
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        var answer = Array<IntArray>(arr1.size){IntArray(arr1[0].size)}
        arr1.forEachIndexed {index, ints ->
            ints.forEachIndexed{innerIndex, innerInts ->
                answer[index][innerIndex] = innerInts + arr2[index][innerIndex]
            } }
        //다른 풀이
        //Array(arr1.size) {
        //            row ->
        //            IntArray(arr1[0].size) {
        //                col ->
        //                arr1[row][col] + arr2[row][col]
        //            }
        return answer
    }
}