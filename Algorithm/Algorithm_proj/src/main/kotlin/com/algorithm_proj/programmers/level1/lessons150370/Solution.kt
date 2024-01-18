package com.algorithm_proj.programmers.level1.lessons150370

class Solution {
    //개인정보 수집 유효기간 - https://school.programmers.co.kr/learn/courses/30/lessons/150370?language=kotlin
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        val termMap = mutableMapOf<String, Int>()

        terms.map { it.split(" ") }.let {
            it.forEach { listOfTerms ->
                termMap[listOfTerms[0]] = listOfTerms[1].toInt()
            }
        }

        var splitOfToday = today.split(".")
        val todaysYear = splitOfToday[0].toInt()
        val todaysMonth = splitOfToday[1].toInt()
        val todaysDay = splitOfToday[2].toInt()

        privacies.forEachIndexed { index, it ->
            val splitPrivacies = it.split(" ")
            val collectionDate = splitPrivacies[0]
            val term = splitPrivacies[1]

            val splitOfCollectionDate = collectionDate.split(".")
            val month = splitOfCollectionDate[1].toInt() + termMap[term]!!
            val shareOfMonth = if (month % 12 == 0) (month / 12) -1 else month / 12
            val expiredMonth = if (month % 12 == 0) 12 else month % 12
            val expiredYear = splitOfCollectionDate[0].toInt() + shareOfMonth
            val expiredDay = splitOfCollectionDate[2].toInt()

            if (expiredYear < todaysYear
                || (expiredYear == todaysYear && expiredMonth < todaysMonth)
                || (expiredYear == todaysYear && expiredMonth == todaysMonth && expiredDay <= todaysDay)
                ) {
                answer = answer.plus(index + 1)
            }
        }
        answer.forEach { println(it) }

        return answer
    }

}