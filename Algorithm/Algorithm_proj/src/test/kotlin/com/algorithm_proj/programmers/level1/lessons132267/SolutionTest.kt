package com.algorithm_proj.programmers.level1.lessons132267

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `a=2, b=1, n=20일 때 result는 19이다`() {
        //given
        val result = solution.solution(2, 1, 20)

        //when

        //then
        assertThat(result).isEqualTo(19)
    }

    @Test
    fun `a=3, b=1, n=20일 때 result는 9이다`() {
        //given
        val result = solution.solution(3, 1, 20)

        //when

        //then
        assertThat(result).isEqualTo(9)
    }
}