package com.algorithm_proj.programmers.level2.lessons12985

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `N=8, A=4, B=7일 때 answer=3`() {
        //given
        val n = 8
        val a = 4
        val b = 7
        val answer = 3

        //when
        val result = solution.solution(n, a, b)

        //then
        assertThat(result).isEqualTo(answer)
    }
}