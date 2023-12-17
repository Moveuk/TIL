package com.algorithm_proj.programmers.level1.lessons147355

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun t1() {
        //given
        val result = solution.solution("3141592", "271")

        //when

        //then
        assertThat(result).isEqualTo(2)
    }

    @Test
    fun t2() {
        //given
        val result = solution.solution("500220839878", "7"	)

        //when

        //then
        assertThat(result).isEqualTo(8)
    }

    @Test
    fun t3() {
        //given
        val result = solution.solution("10203", "15")

        //when

        //then
        assertThat(result).isEqualTo(3)
    }
}