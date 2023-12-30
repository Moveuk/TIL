package com.algorithm_proj.programmers.level1.lessons42840

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `answer={1,2,3,4,5}이면 반환값은 {1}이다`() {
        //given
        val result = solution.solution(intArrayOf(1,2,3,4,5))

        //when

        //then
        assertThat(result).isEqualTo(intArrayOf(1))
    }

    @Test
    fun `answer={1,3,2,4,2}이면 반환값은 {1,2,3}이다`() {
        //given
        val result = solution.solution(intArrayOf(1,3,2,4,2))

        //when

        //then
        assertThat(result).isEqualTo(intArrayOf(1,2,3))
    }
}