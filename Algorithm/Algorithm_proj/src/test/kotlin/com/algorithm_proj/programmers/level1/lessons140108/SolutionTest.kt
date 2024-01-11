package com.algorithm_proj.programmers.level1.lessons140108

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `s="banana"일 때 result=3이다`() {
        //given
        val result = solution.solution("banana")

        //when

        //then
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun `s="abracadabra"일 때 result=6이다`() {
        //given
        val result = solution.solution("abracadabra")

        //when

        //then
        assertThat(result).isEqualTo(6)
    }

    @Test
    fun `s="aaabbaccccabba"일 때 result=3이다`() {
        //given
        val result = solution.solution("aaabbaccccabba")

        //when

        //then
        assertThat(result).isEqualTo(3)
    }
}