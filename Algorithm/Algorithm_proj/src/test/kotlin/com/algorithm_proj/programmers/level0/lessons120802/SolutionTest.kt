package com.algorithm_proj.programmers.level0.lessons120802

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun t1() {
        //given
        val result = solution.solution(2, 3)

        //when

        //then
        assertThat(result).isEqualTo(5)
    }

    @Test
    fun t2() {
        //given
        val result = solution.solution(100, 2)

        //when

        //then
        assertThat(result).isEqualTo(102)
    }
}