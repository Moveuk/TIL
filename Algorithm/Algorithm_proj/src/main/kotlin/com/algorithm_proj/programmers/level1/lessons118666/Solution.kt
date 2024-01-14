package com.algorithm_proj.programmers.level1.lessons118666

class Solution {
    //성격 유형 검사하기 - https://school.programmers.co.kr/learn/courses/30/lessons/118666
    fun solution(survey: Array<String>, choices: IntArray): String {
        var answer = StringBuilder()
        val scoreBoard = intArrayOf(-1, 3, 2, 1, 0, 1, 2, 3)
        val surveyPointStorage = mutableMapOf<Char, Int>()
        // val scoreMap = mutableMapOf("RT" to 0, "CF" to 0, "JM" to 0, "AN" to 0)

        for (index in survey.indices) {
            val letterOfEachSurvey: Char
            if (choices[index] in 1..3) {
                letterOfEachSurvey = survey[index][0]
                surveyPointStorage[letterOfEachSurvey] =
                    surveyPointStorage.getOrDefault(letterOfEachSurvey, 0) + scoreBoard[choices[index]]
            } else {
                letterOfEachSurvey = survey[index][1]
                surveyPointStorage[letterOfEachSurvey] =
                    surveyPointStorage.getOrDefault(letterOfEachSurvey, 0) + scoreBoard[choices[index]]
            }
        }

        //RT
        answer.append(getCharacterLetter(surveyPointStorage, arrayOf('R', 'T')))
        //CF
        answer.append(getCharacterLetter(surveyPointStorage, arrayOf('C', 'F')))
        //JM
        answer.append(getCharacterLetter(surveyPointStorage, arrayOf('J', 'M')))
        //AN
        answer.append(getCharacterLetter(surveyPointStorage, arrayOf('A', 'N')))
        return answer.toString()
    }

    fun getCharacterLetter(surveyPointStorage: MutableMap<Char, Int>, arrayOfCharacterLetters: Array<Char>): Char {
        val firstLetter = arrayOfCharacterLetters[0]
        val secondLetter = arrayOfCharacterLetters[1]
        val entryFirstKey = surveyPointStorage.filter { it.key == firstLetter }
        val entrySecondKey = surveyPointStorage.filter { it.key == secondLetter }
        val firstValue = entryFirstKey.getOrDefault(firstLetter, 0)
        val secondValue = entrySecondKey.getOrDefault(secondLetter, 0)

        return if (firstValue > secondValue) firstLetter
        else if (firstValue == secondValue) firstLetter
        else secondLetter
    }

//    fun solution(survey: Array<String>, choices: IntArray): String {
//        val orders = listOf("RT", "CF", "JM", "AN")
//        return choices
//            .mapIndexed { index, i ->
//                if (i-4 < 0) {
//                    survey[index][0] to -(i-4)
//                } else {
//                    survey[index][1] to (i-4)
//                }
//            }
//            .groupBy { it.first }
//            .map { it.key to it.value.sumOf { v:Pair<Char, Int> -> v.second } }
//            .toMap()
//            .let { ans:Map<Char, Int> ->
//                orders.map {
//                    if (ans.getOrDefault(it[0], 0) >= ans.getOrDefault(it[1], 0)) it[0] else it[1]
//                }
//            }
//            .joinToString("")
//    }
}