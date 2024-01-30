package com.algorithm_proj.programmers.level1.lessons12903

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `s="abcde"일 때 return="c"이다`() {
        //given
        val s = "abcde"

        //when
        val result = solution.solution(s)

        //then
        assertThat(result).isEqualTo("c")
    }

    @Test
    fun `s="qwer"일 때 return="we"이다`() {
        //given
        val s = "qwer"

        //when
        val result = solution.solution(s)

        //then
        assertThat(result).isEqualTo("we")
    }
}