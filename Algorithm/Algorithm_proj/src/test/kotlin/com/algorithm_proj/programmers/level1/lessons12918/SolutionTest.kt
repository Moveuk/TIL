package com.algorithm_proj.programmers.level1.lessons12918

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    val solution = Solution()

    @Test
    fun t1() {
        //given
        val result = solution.solution("a234")

        //when

        //then
        assertThat(result).isEqualTo(false)
    }

    @Test
    fun t2() {
        //given
        val result = solution.solution("1234")

        //when

        //then
        assertThat(result).isEqualTo(true)
    }
}