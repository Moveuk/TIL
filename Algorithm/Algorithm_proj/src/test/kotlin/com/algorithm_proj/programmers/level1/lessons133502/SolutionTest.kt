package com.algorithm_proj.programmers.level1.lessons133502

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `ingredient={2, 1, 1, 2, 3, 1, 2, 3, 1}일 때 result=2이다`() {
        //given
        val result = solution.solution(intArrayOf(2, 1, 1, 2, 3, 1, 2, 3, 1))

        //when

        //then
        assertThat(result).isEqualTo(2)
    }

    @Test
    fun `ingredient={1, 3, 2, 1, 2, 1, 3, 1, 2}일 때 result=0이다`() {
        //given
        val result = solution.solution(intArrayOf(1, 3, 2, 1, 2, 1, 3, 1, 2))

        //when

        //then
        assertThat(result).isEqualTo(0)
    }

    @Test
    fun `ingredient={1, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1}일 때 result=3이다`() {
        //given
        val result = solution.solution(intArrayOf(1, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1))

        //when

        //then
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun `ingredient={2, 2, 2, 2, 2, 2, 1, 2, 1, 2, 3, 1, 3, 1}일 때 result=2이다`() {
        //given
        val result = solution.solution(intArrayOf(2, 2, 2, 2, 2, 2, 1, 2, 1, 2, 3, 1, 3, 1))

        //when

        //then
        assertThat(result).isEqualTo(2)
    }
}