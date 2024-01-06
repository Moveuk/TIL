package com.algorithm_proj.programmers.level1.lessons42862

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `n=5, lost={2, 4}, reverse={1, 3, 5}일 때 return=5이다`() {
        //given
        val result = solution.solution(5, intArrayOf(2, 4), intArrayOf(1, 3, 5))

        //when

        //then
        assertThat(result).isEqualTo(5)
    }

    @Test
    fun `n=5, lost={2, 4}, reverse={3}일 때 return=4이다`() {
        //given
        val result = solution.solution(5, intArrayOf(2, 4), intArrayOf(3))

        //when

        //then
        assertThat(result).isEqualTo(4)
    }

    @Test
    fun `n=3, lost={3}, reverse={1}일 때 return=2이다`() {
        //given
        val result = solution.solution(3, intArrayOf(3), intArrayOf(1))

        //when

        //then
        assertThat(result).isEqualTo(2)
    }
}