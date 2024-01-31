package com.algorithm_proj.programmers.level1.lessons12939

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `s="1 2 3 4"일 떄 return="1 4"이다`() {
        //given
        val s = "1 2 3 4"

        //when
        val result = solution.solution(s)

        //then
        assertThat(result).isEqualTo("1 4")
    }

    @Test
    fun `s="-1 -2 -3 -4"일 떄 return="-4 -1"이다`() {
        //given
        val s = "-1 -2 -3 -4"

        //when
        val result = solution.solution(s)

        //then
        assertThat(result).isEqualTo("-4 -1")
    }

    @Test
    fun `s="-1 -1"일 떄 return="-1 -1"이다`() {
        //given
        val s = "-1 -1"

        //when
        val result = solution.solution(s)

        //then
        assertThat(result).isEqualTo("-1 -1")
    }
}