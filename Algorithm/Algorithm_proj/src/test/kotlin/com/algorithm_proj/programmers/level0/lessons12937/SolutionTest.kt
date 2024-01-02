package com.algorithm_proj.programmers.level0.lessons12937

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `num=3일때 결과는 Odd이다`() {
        //given
        val result = solution.solution(3)

        //when

        //then
        assertThat(result).isEqualTo("Odd")
    }

    @Test
    fun `num=4일때 결과는 Even이다`() {
        //given
        val result = solution.solution(4)

        //when

        //then
        assertThat(result).isEqualTo("Even")
    }
}