package com.algorithm_proj.programmers.level0.lessons120831

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `n=10일 때 result=30이다`() {
        //given
        val result = solution.solution(10)

        //when

        //then
        assertThat(result).isEqualTo(30)
    }

    @Test
    fun `n=4일 때 result=6이다`() {
        //given
        val result = solution.solution(4)

        //when

        //then
        assertThat(result).isEqualTo(6)
    }
}