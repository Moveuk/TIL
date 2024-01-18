package com.algorithm_proj.programmers.level1.lessons150370

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `today, terms, privacies가 다음과 같을 때 result는 {1,3}이다`() {
        //given
        val today = "2022.05.19"
        val terms = arrayOf("A 6", "B 12", "C 3")
        val privacies = arrayOf("2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C")

        //when
        val result = solution.solution(today, terms, privacies)

        //then
        assertThat(result).isEqualTo(intArrayOf(1, 3))
    }

    @Test
    fun `today, terms, privacies가 다음과 같을 때 result는 {1, 4, 5}이다`() {
        //given
        val today = "2020.01.01"
        val terms = arrayOf("Z 3", "D 5")
        val privacies = arrayOf("2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z")

        //when
        val result = solution.solution(today, terms, privacies)

        //then
        assertThat(result).isEqualTo(intArrayOf(1, 4, 5))
    }
}