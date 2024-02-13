package com.algorithm_proj.programmers.level1.lessons138476

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `k=6, tangerine={1, 3, 2, 5, 4, 5, 2, 3}일 때 result=3`() {
        //given
        val k = 6
        val tangerine = intArrayOf(1, 3, 2, 5, 4, 5, 2, 3)
        val expect = 3

        //when
        val result = solution.solution(k, tangerine)

        //then
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `k=4, tangerine={1, 3, 2, 5, 4, 5, 2, 3}일 때 result=2`() {
        //given
        val k = 4
        val tangerine = intArrayOf(1, 3, 2, 5, 4, 5, 2, 3)
        val expect = 2

        //when
        val result = solution.solution(k, tangerine)

        //then
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `k=2, tangerine={1, 1, 1, 1, 2, 2, 2, 3}일 때 result=1`() {
        //given
        val k = 2
        val tangerine = intArrayOf(1, 1, 1, 1, 2, 2, 2, 3)
        val expect = 1

        //when
        val result = solution.solution(k, tangerine)

        //then
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `k=2, tangerine={1000, 2000, 2000, 1000}일 때 result=1`() {
        //given
        val k = 2
        val tangerine = intArrayOf(1000, 2000, 2000, 1000)
        val expect = 1

        //when
        val result = solution.solution(k, tangerine)

        //then
        assertThat(result).isEqualTo(expect)
    }
}