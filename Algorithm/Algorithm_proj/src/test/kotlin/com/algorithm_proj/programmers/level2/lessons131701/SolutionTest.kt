package com.algorithm_proj.programmers.level2.lessons131701

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `elements={7, 9, 1, 1, 4}일 때 result=18이다`() {
        //given
        val elements = intArrayOf(7, 9, 1, 1, 4)

        //when
        val result = solution.solution(elements)

        //then
        assertThat(result).isEqualTo(18)
    }
}