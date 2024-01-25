package com.algorithm_proj.programmers.level1.lessons12910

class Solution {
    //나누어 떨어지는 숫자 배열 - https://school.programmers.co.kr/learn/courses/30/lessons/12910
    fun solutionFromProgrammers(arr: IntArray, divisor: Int): IntArray {
        var answer = intArrayOf()

        arr.forEach { if (it % divisor == 0) answer += it }
        answer.sort()

        if (answer.size == 0) answer += -1

        return answer
    }
    fun solution(arr: IntArray, divisor: Int): IntArray {
        var index = 0 // answer 위치 값
        val sample = IntArray(arr.size)
        for (i in arr.indices) {
            if (arr[i] % divisor == 0) {
                sample[index++] = arr[i]
            }
        }

        val answer = IntArray(index)

        if (index == 0) {
            return intArrayOf(-1)
        } else {
            for (i in 0 until index) {
                answer[i] = sample[i]
            }
        }
        // quickSort sort 해야함
        quickSort(answer)

        return answer
    }

    fun quickSort(arr: IntArray) {
        quickSort(arr, 0, arr.size - 1)
    }

    private fun quickSort(arr: IntArray, left: Int, right: Int) {
        // 더 이상 분할이 되지 않으면 종료
        if (left >= right) return

        val mid = partition(arr, left, right)
        quickSort(arr, left, mid - 1)
        quickSort(arr, mid, right)
    }

    // 분할
    private fun partition(arr: IntArray, left: Int, right: Int): Int {
        var left = left
        var right = right
        val pivot = arr[(left + right) / 2]

        // 엇갈리지 않으면 계속 반복
        while (left <= right) { // 1. 배열에 값이 중복해서 들어가는 경우는 <=

            // left와 right 찾기

            while (arr[left] < pivot) left++
            while (arr[right] > pivot) right--

            // 엇갈리지 않으면 swap
            if (left <= right) { // 2. 1과 동일
                swap(arr, left, right)
                left++
                right--
            }
        }
        return left
    }

    private fun swap(arr: IntArray, a: Int, b: Int) {
        val temp = arr[a]
        arr[a] = arr[b]
        arr[b] = temp
    }
}