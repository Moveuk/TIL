package com.algorithm_proj.programmers.level0.lessons120817

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `numbers={1, 2, 3, 4, 5, 6, 7, 8, 9, 10}이면 결과는 5,5이다`() {
        //given
        val result = solution.solution(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))

        //when

        //then
        assertThat(result).isEqualTo(5.5)
    }

    @Test
    fun `numbers={89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99}이면 결과는 94,0이다`() {
        //given
        val result = solution.solution(intArrayOf(89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99))

        //when

        //then
        assertThat(result).isEqualTo(94.0)
    }
}