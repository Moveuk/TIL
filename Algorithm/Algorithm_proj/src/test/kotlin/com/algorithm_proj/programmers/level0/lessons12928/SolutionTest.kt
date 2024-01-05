package com.algorithm_proj.programmers.level0.lessons12928

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `n=12일 때 return은 28이다`() {
        //given
        val result = solution.solution(12)

        //when

        //then
        assertThat(result).isEqualTo(28)
    }

    @Test
    fun `n=5일 때 return은 6이다`() {
        //given
        val result = solution.solution(5)

        //when

        //then
        assertThat(result).isEqualTo(6)
    }
}