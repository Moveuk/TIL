package com.algorithm_proj.programmers.level1.lessons12914

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `n=4일 때 result=5`() {
        //given
        val n = 4
        val expect = 5L

        //when
        val result = solution.solution(n)

        //then
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `n=3일 때 result=3`() {
        //given
        val n = 3
        val expect = 3L

        //when
        val result = solution.solution(n)

        //then
        assertThat(result).isEqualTo(expect)
    }
}