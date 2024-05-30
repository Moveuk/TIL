package com.algorithm_proj.programmers.level2.lessons42587

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `priorities={2, 1, 3, 2}, location=2일 때 reault는 1이다`() {
        //given
        val priorities= intArrayOf(2, 1, 3, 2)
        val location = 2

        //when
        val result = solution.solution(priorities, location)

        //then
        assertThat(result).isEqualTo(1)
    }

    @Test
    fun `priorities={1, 1, 9, 1, 1, 1}, location=0일 때 reault는 5이다`() {
        //given
        val priorities= intArrayOf(1, 1, 9, 1, 1, 1)
        val location = 0

        //when
        val result = solution.solution(priorities, location)

        //then
        assertThat(result).isEqualTo(5)
    }
}