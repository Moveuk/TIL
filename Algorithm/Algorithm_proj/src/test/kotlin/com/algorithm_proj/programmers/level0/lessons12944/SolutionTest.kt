package com.algorithm_proj.programmers.level0.lessons12944

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `arr={1,2,3,4}일 때 return=2,5이다`() {
        //given
        val result = solution.solution(intArrayOf(1, 2, 3, 4))

        //when

        //then
        assertThat(result).isEqualTo(2.5)
    }

    @Test
    fun `arr={5, 5}일 때 return=5이다`() {
        //given
        val result = solution.solution(intArrayOf(5, 5))

        //when

        //then
        assertThat(result).isEqualTo(5.0)
    }
}