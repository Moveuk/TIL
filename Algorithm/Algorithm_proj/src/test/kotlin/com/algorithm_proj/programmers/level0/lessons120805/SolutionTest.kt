package com.algorithm_proj.programmers.level0.lessons120805

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun t1() {
        //given
        val result = solution.solution(10,5)

        //when

        //then
        assertThat(result).isEqualTo(2)
    }
    @Test
    fun t2() {
        //given
        val result = solution.solution(7,2)

        //when

        //then
        assertThat(result).isEqualTo(3)
    }
}