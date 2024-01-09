package com.algorithm_proj.programmers.level1.lessons12925

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `s="1234"일 때 return=1234`() {
        //given
        val result = solution.solution("1234")

        //when

        //then
        assertThat(result).isEqualTo(1234)
    }

    @Test
    fun `s="-1234"일 때 return=-1234`() {
        //given
        val result = solution.solution("-1234")

        //when

        //then
        assertThat(result).isEqualTo(-1234)
    }
}