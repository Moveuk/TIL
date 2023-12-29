package com.algorithm_proj.programmers.level1.lessons135808

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `k=3, m=4, score={1, 2, 3, 1, 2, 3, 1}을 넣으면 result=8이 나온다`() {
        //given
        val result = solution.solution(3, 4, intArrayOf(1, 2, 3, 1, 2, 3, 1))

        //when

        //then
        assertThat(result).isEqualTo(8)
    }

    @Test
    fun `k=4, m=3, score={4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2}을 넣으면 result=33이 나온다`() {
        //given
        val result = solution.solution(4, 3, intArrayOf(4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2))

        //when

        //then
        assertThat(result).isEqualTo(33)
    }
}