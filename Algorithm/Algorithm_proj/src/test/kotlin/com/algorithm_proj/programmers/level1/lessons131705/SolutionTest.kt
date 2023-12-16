package com.algorithm_proj.programmers.level1.lessons131705

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun t1() {
        //given
        val result = solution.solution(intArrayOf(-2, 3, 0, 2, -5))

        //when

        //then
        assertThat(result).isEqualTo(2)
    }

    @Test
    fun t2() {
        //given
        val result = solution.solution(intArrayOf(-3, -2, -1, 0, 1, 2, 3))

        //when

        //then
        assertThat(result).isEqualTo(5)
    }

    @Test
    fun t3() {
        //given
        val result = solution.solution(intArrayOf(-1, 1, -1, 1))

        //when

        //then
        assertThat(result).isEqualTo(0)
    }
}