package com.algorithm_proj.programmers.level1.lessons136798

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `number=5, limit=3, power=2일 때 result=10이다`() {
        //given
        val result = solution.solution(5, 3, 2)

        //when

        //then
        assertThat(result).isEqualTo(10)
    }

    @Test
    fun `number=10, limit=3, power=2일 때 result=21이다`() {
        //given
        val result = solution.solution(10, 3, 2)

        //when

        //then
        assertThat(result).isEqualTo(21)
    }
}