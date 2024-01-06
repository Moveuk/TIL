package com.algorithm_proj.programmers.level0.lessons87389

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `n=10일 때 result=3이다`() {
        //given
        val result = solution.solution(10)

        //when

        //then
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun `n=12일 때 result=11이다`() {
        //given
        val result = solution.solution(12)

        //when

        //then
        assertThat(result).isEqualTo(11)
    }
}