package com.algorithm_proj.programmers.level1.lessons12934

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `n=121일 때 return=144`() {
        //given
        val result = solution.solution(121)

        //when

        //then
        assertThat(result).isEqualTo(144)
    }

    @Test
    fun `n=3 때 return=-1`() {
        //given
        val result = solution.solution(3)

        //when

        //then
        assertThat(result).isEqualTo(-1)
    }
}