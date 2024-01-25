package com.algorithm_proj.programmers.level1.lessons12910

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `arr={5, 9, 7, 10}, divisor=5일 때 return={5, 10}이다`() {
        //given
        val arr = intArrayOf(5, 9, 7, 10)
        val divisor = 5

        //when
        val result = solution.solution(arr, divisor)

        //then
        assertThat(result).isEqualTo(intArrayOf(5, 10))
    }

    @Test
    fun `arr={2, 36, 1, 3}, divisor=1일 때 return={1, 2, 3, 36}이다`() {
        //given
        val arr = intArrayOf(2, 36, 1, 3)
        val divisor = 1

        //when
        val result = solution.solution(arr, divisor)

        //then
        assertThat(result).isEqualTo(intArrayOf(1, 2, 3, 36))
    }

    @Test
    fun `arr={3,2,6}, divisor=10일 때 return={-1}이다`() {
        //given
        val arr = intArrayOf(3,2,6)
        val divisor = 10

        //when
        val result = solution.solution(arr, divisor)

        //then
        assertThat(result).isEqualTo(intArrayOf(-1))
    }
}