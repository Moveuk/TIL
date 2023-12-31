package com.algorithm_proj.programmers.level1.lessons12977

class Solution {
    //소수 만들기 - https://school.programmers.co.kr/learn/courses/30/lessons/12977?language=kotlin
    private val caches = HashSet<Int>()
    fun solution(nums: IntArray): Int {
        var answer = 0
        val combinationList = combination(nums.toTypedArray(), 3)

        combinationList.forEach { eachCombi ->
            val sum = eachCombi.sum()

            //소수 검색을 위한 나눗셈용 어레이
            val intArray = (2..sum - 1).toList().toIntArray()

            //기존 캐시에 소수임이 증명된 것이 있다면 그 숫자는 소수이므로 바로 count
            if (caches.contains(sum)) {
                answer++
                return@forEach
            }

            //나눠지는 것이 있으면 소수 아님
            if (intArray.any { eachInt -> sum % eachInt == 0 }) {
                return@forEach
            }

            //나누어지는게 없으면 caches에 약수임을 담아둠. (효율성을 높이기 위한 용도)
            caches.add(sum)
            answer++
        }

        return answer
    }

    private fun <T> combination(elements: Array<T>, r: Int): List<List<T>> {
        val n = elements.size
        val results = mutableListOf<List<T>>() // the number of all cases

        val result = elements.sliceArray(0 until r)

        fun recursionCombination(depth: Int = 0, index: Int = 0) {
            if (depth == r) {
                results.add(result.toList())
                return
            }

            for (i in index until n) {
                result[depth] = elements[i]
                recursionCombination(depth + 1, i + 1)
            }
        }

        recursionCombination()
        return results
    }
}