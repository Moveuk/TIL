package com.algorithm_proj.programmers.level1.lessons42747

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `citations={3, 0, 6, 1, 5}일 때 return=3이다`() {
        //given
        val citations= intArrayOf(3, 0, 6, 1, 5)
        val expect = 3

        //when
        val result = solution.solution(citations)

        //then
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `citations={100, 100, 100}일 때 return=3이다`() {
        //given
        val citations= intArrayOf(100, 100, 100)
        val expect = 3

        //when
        val result = solution.solution(citations)

        //then
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `citations={3, 4}일 때 return=2이다`() {
        //given
        val citations= intArrayOf(3, 4)
        val expect = 2

        //when
        val result = solution.solution(citations)

        //then
        assertThat(result).isEqualTo(expect)
    }
}