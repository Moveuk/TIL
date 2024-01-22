package com.algorithm_proj.programmers.level1.lessons12912

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `a=3, b=5 return=12`() {
        //given
        val a = 3
        val b = 5

        //when
        val result = solution.solution(a, b)

        //then
        assertThat(result).isEqualTo(12)
    }

    @Test
    fun `a=3, b=3 return=3`() {
        //given
        val a = 3
        val b = 3

        //when
        val result = solution.solution(a, b)

        //then
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun `a=5, b=3 return=12`() {
        //given
        val a = 5
        val b = 3

        //when
        val result = solution.solution(a, b)

        //then
        assertThat(result).isEqualTo(12)
    }
}