package com.algorithm_proj.programmers.level1.lessons68935

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun t1() {
        //given
        val result = solution.solution(45)

        //when

        //then
        assertThat(result).isEqualTo(7)
    }

    @Test
    fun t2() {
        //given
        val result = solution.solution(125)

        //when

        //then
        assertThat(result).isEqualTo(229)
    }
}