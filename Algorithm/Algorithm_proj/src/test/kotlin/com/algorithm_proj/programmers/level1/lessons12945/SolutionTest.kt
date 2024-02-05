package com.algorithm_proj.programmers.level1.lessons12945

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `n=3 return=2`() {
        //given
        val n = 3
        val returns = 2

        //when
        val result = solution.solution(n)

        //then
        assertThat(result).isEqualTo(returns)
    }

    @Test
    fun `n=5 return=5`() {
        //given
        val n = 5
        val returns = 5

        //when
        val result = solution.solution(n)

        //then
        assertThat(result).isEqualTo(returns)
    }
}