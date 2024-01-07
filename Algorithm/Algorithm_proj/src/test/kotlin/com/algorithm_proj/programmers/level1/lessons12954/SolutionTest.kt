package com.algorithm_proj.programmers.level1.lessons12954

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `x=2, n=5일 때 answer={2,4,6,8,10}`() {
        //given
        val result = solution.solution(2, 5)

        //when

        //then
        assertThat(result).isEqualTo(longArrayOf(2, 4, 6, 8, 10))
    }

    @Test
    fun `x=4, n=3일 때 answer={4,8,12}`() {
        //given
        val result = solution.solution(4, 3)

        //when

        //then
        assertThat(result).isEqualTo(longArrayOf(4, 8, 12))
    }

    @Test
    fun `x=-4, n=2일 때 answer={2,4,6,8,10}`() {
        //given
        val result = solution.solution(-4, 2)

        //when

        //then
        assertThat(result).isEqualTo(longArrayOf(-4, -8))
    }
}