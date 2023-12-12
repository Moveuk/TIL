package com.algorithm_proj.programmers.level1.lessons12940

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun t1() {
        //given
        val result = solution.solution(3, 12)

        //when

        //then
        assertThat(result).isEqualTo(intArrayOf(3, 12))
    }

    @Test
    fun t2() {
        //given
        val result = solution.solution(2, 5)

        //when

        //then
        assertThat(result).isEqualTo(intArrayOf(1, 10))
    }
}