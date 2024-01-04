package com.algorithm_proj.programmers.level0.lessons12931

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `N=123이면 answer는 6이다`() {
        //given
        val result = solution.solution(123)

        //when

        //then
        assertThat(result).isEqualTo(6)
    }

    @Test
    fun `N=987이면 answer는 24이다`() {
        //given
        val result = solution.solution(987)

        //when

        //then
        assertThat(result).isEqualTo(24)
    }
}