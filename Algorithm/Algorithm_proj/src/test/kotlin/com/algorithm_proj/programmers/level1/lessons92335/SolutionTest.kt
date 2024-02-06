package com.algorithm_proj.programmers.level1.lessons92335

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `n=437674, k=3일 때 result=3이다`() {
        //given
        val n = 437674
        val k = 3
        val expect = 3

        //when
        val result = solution.solution(n, k)

        //then
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `n=110011, k=10일 때 result=2이다`() {
        //given
        val n = 110011
        val k = 10
        val expect = 2

        //when
        val result = solution.solution(n, k)

        //then
        assertThat(result).isEqualTo(expect)
    }
}