package com.algorithm_proj.programmers.level1.lessons12932

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `n=12345일 때 return={5,4,3,2,1}이다`() {
        //given
        val result = solution.solution(12345)

        //when

        //then
        assertThat(result).isEqualTo(intArrayOf(5, 4, 3, 2, 1))
    }
}