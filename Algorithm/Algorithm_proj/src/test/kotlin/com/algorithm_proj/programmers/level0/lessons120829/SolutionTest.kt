package com.algorithm_proj.programmers.level0.lessons120829

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `angle=70이면 result=1이다`() {
        //given
        val result = solution.solution(70)

        //when

        //then
        assertThat(result).isEqualTo(1)
    }

    @Test
    fun `angle=91이면 result=3이다`() {
        //given
        val result = solution.solution(91)

        //when

        //then
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun `angle=180이면 result=4이다`() {
        //given
        val result = solution.solution(180)

        //when

        //then
        assertThat(result).isEqualTo(4)
    }
}