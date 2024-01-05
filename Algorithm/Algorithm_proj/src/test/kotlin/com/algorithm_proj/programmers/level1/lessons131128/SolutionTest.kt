package com.algorithm_proj.programmers.level1.lessons131128

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `X="100", Y="2345"이면 result="-1"이다`() {
        //given
        val result = solution.solution("100", "2345")

        //when

        //then
        assertThat(result).isEqualTo("-1")
    }

    @Test
    fun `X="100", Y="203045"이면 result="0"이다`() {
        //given
        val result = solution.solution("100", "203045")

        //when

        //then
        assertThat(result).isEqualTo("0")
    }

    @Test
    fun `X="100", Y="123450"이면 result="10"이다`() {
        //given
        val result = solution.solution("100", "123450")

        //when

        //then
        assertThat(result).isEqualTo("10")
    }

    @Test
    fun `X="12321", Y="42531"이면 result="321"이다`() {
        //given
        val result = solution.solution("12321", "42531")

        //when

        //then
        assertThat(result).isEqualTo("321")
    }

    @Test
    fun `X="5525", Y="1255"이면 result="552"이다`() {
        //given
        val result = solution.solution("5525", "1255")

        //when

        //then
        assertThat(result).isEqualTo("552")
    }

    @Test
    fun `X="1111", Y="111"이면 result="111"이다`() {
        //given
        val result = solution.solution("1111", "111")

        //when

        //then
        assertThat(result).isEqualTo("111")
    }
}