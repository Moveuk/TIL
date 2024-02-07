package com.algorithm_proj.programmers.level1.lessons92334

class Solution {
    //신고 결과 받기 - https://school.programmers.co.kr/learn/courses/30/lessons/92334
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        val answer = IntArray(id_list.size)
        val memoryReportToFrom = HashMap<String, Set<String>>() //누가 누구를 신고 했는지
        val memoryReportNumById = HashMap<String, Int>()

        //모든 유저 초기화
        id_list.forEach {
            memoryReportToFrom[it] = setOf()
            memoryReportNumById[it] = 0
        }

        //신고 돌면서 누가 누구를 신고했고 누가 누구한테 당했는지 확인
        report.forEach {
            val (reportFrom, reportTo) = it.split(" ")
            memoryReportToFrom[reportTo] = memoryReportToFrom[reportTo]!!.plus(reportFrom)
        }

        //신고 받은 사람 정산
        id_list.forEach {
            if (memoryReportToFrom[it]!!.size >= k) {
                memoryReportToFrom[it]!!.forEach { to ->
                    memoryReportNumById[to] = memoryReportNumById[to]!! + 1
                }
            }
        }

        //순서 정렬
        id_list.forEachIndexed { index, name ->
            answer[index] = memoryReportNumById[name]!!
        }

        return answer
    }
    //    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray =
    //    report.map { it.split(" ") }
    //        .groupBy { it[1] }
    //        .asSequence()
    //        .map { it.value.distinct() }
    //        .filter { it.size >= k }
    //        .flatten()
    //        .map { it[0] }
    //        .groupingBy { it }
    //        .eachCount()
    //        .run { id_list.map { getOrDefault(it, 0) }.toIntArray() }
}