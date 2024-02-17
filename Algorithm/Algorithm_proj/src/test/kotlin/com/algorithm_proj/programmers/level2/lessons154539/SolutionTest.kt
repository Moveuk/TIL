package com.algorithm_proj.programmers.level2.lessons154539

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `numbers={2, 3, 3, 5}일 때 result={3, 5, 5, -1}이다`() {
        //given
        val numbers = intArrayOf(2, 3, 3, 5)
        val expect = intArrayOf(3, 5, 5, -1)

        //when
        val result = solution.solution(numbers)

        //then
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `numbers={9, 1, 5, 3, 6, 2}일 때 result={-1, 5, 6, 6, -1, -1}이다`() {
        //given
        val numbers = intArrayOf(9, 1, 5, 3, 6, 2)
        val expect = intArrayOf(-1, 5, 6, 6, -1, -1)

        //when
        val result = solution.solution(numbers)

        //then
        assertThat(result).isEqualTo(expect)
    }
}