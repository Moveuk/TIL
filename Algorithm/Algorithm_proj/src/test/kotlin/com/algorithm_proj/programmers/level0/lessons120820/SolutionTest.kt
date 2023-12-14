package com.algorithm_proj.programmers.level0.lessons120820

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun t1() {
        //given
        val result = solution.solution(40)

        //when

        //then
        assertThat(result).isEqualTo(1983)
    }
    @Test
    fun t2() {
        //given
        val result = solution.solution(23)

        //when

        //then
        assertThat(result).isEqualTo(2000)
    }
}