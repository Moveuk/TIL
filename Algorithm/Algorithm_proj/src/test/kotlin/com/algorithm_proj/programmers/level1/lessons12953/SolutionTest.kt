package com.algorithm_proj.programmers.level1.lessons12953

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `arr={2,6,8,14}일 때 return=168`() {
        //given
        val arr = intArrayOf(2,6,8,14)
        val expect = 168

        //when
        val result = solution.solution(arr)

        //then
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `arr={1,2,3}일 때 return=6`() {
        //given
        val arr = intArrayOf(1,2,3)
        val expect = 6

        //when
        val result = solution.solution(arr)

        //then
        assertThat(result).isEqualTo(expect)
    }
}