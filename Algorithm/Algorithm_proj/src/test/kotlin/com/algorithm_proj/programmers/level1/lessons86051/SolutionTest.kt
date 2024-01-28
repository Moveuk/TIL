package com.algorithm_proj.programmers.level1.lessons86051

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `numbers={1,2,3,4,6,7,8,0}일 때 result=14`() {
        //given
        val numbers = intArrayOf(1, 2, 3, 4, 6, 7, 8, 0)

        //when
        val result = solution.solution(numbers)

        //then
        assertThat(result).isEqualTo(14)
    }

    @Test
    fun `numbers={5,8,4,0,6,7,9}일 때 result=6`() {
        //given
        val numbers = intArrayOf(5, 8, 4, 0, 6, 7, 9)

        //when
        val result = solution.solution(numbers)

        //then
        assertThat(result).isEqualTo(6)
    }
}