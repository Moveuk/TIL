package com.algorithm_proj.programmers.level1.lessons70129

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `s="110010101001"일 때 result={3,8}`() {
        //given
        val s = "110010101001"
        val expect = intArrayOf(3,8)

        //when
        val result = solution.solution(s)

        //then
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `s="1111111"일 때 result={4,1}`() {
        //given
        val s = "1111111"
        val expect = intArrayOf(4,1)

        //when
        val result = solution.solution(s)

        //then
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `s="01110"일 때 result={3,3}`() {
        //given
        val s = "01110"
        val expect = intArrayOf(3,3)

        //when
        val result = solution.solution(s)

        //then
        assertThat(result).isEqualTo(expect)
    }
}