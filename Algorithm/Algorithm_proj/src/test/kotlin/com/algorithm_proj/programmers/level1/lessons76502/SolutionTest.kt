package com.algorithm_proj.programmers.level1.lessons76502

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `s일 때 result=3`() {
        //given
        val s = "[](){}"
        val expect = 3

        //when
        val result = solution.solution(s)

        //then
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `s일 때 result=2`() {
        //given
        val s = "}]()[{"
        val expect = 2

        //when
        val result = solution.solution(s)

        //then
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `s일 때 result=0`() {
        //given
        val s = "[)(]"
        val expect = 0

        //when
        val result = solution.solution(s)

        //then
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `s=}}}일 때 result=0`() {
        //given
        val s = "}}}"
        val expect = 0

        //when
        val result = solution.solution(s)

        //then
        assertThat(result).isEqualTo(expect)
    }
}