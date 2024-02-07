package com.algorithm_proj.programmers.level1.lessons92334

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `id_list={"muzi", "frodo", "apeach", "neo"}, report={"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, k=2일 때 result={2,1,1,0}`() {
        //given
        val id_list = arrayOf("muzi", "frodo", "apeach", "neo")
        val report = arrayOf("muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi")
        val k = 2

        //when
        val result = solution.solution(id_list, report, k)

        //then
        assertThat(result).isEqualTo(intArrayOf(2, 1, 1, 0))
    }

    @Test
    fun `id_list={"con", "ryan"}, report={"ryan con", "ryan con", "ryan con", "ryan con"}, k=3일 때 result={0,0}`() {
        //given
        val id_list = arrayOf("con", "ryan")
        val report = arrayOf("ryan con", "ryan con", "ryan con", "ryan con")
        val k = 3

        //when
        val result = solution.solution(id_list, report, k)

        //then
        assertThat(result).isEqualTo(intArrayOf(0,0))
    }
}