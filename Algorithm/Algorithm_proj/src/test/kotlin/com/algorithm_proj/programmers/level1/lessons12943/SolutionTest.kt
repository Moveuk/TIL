package com.algorithm_proj.programmers.level1.lessons12943

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `n=6일 때 result=8`() {
        //given
        val n = 6

        //when
        val result = solution.solution(n)

        //then
        assertThat(result).isEqualTo(8)
    }

    @Test
    fun `n=16일 때 result=4`() {
        //given
        val n = 16

        //when
        val result = solution.solution(n)

        //then
        assertThat(result).isEqualTo(4)
    }

    @Test
    fun `n=626331일 때 result=-1`() {
        //given
        val n = 626331

        //when
        val result = solution.solution(n)

        //then
        assertThat(result).isEqualTo(-1)
    }
}