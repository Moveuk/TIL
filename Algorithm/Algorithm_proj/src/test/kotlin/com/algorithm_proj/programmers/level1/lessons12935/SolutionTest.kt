package com.algorithm_proj.programmers.level1.lessons12935

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `arr={4,3,2,1}일 때 return={4,3,2}`() {
        //given
        val arr = intArrayOf(4,3,2,1)

        //when
        val result = solution.solution(arr)

        //then
        assertThat(result).isEqualTo(intArrayOf(4,3,2))
    }

    @Test
    fun `arr={10}일 때 return={-1}`() {
        //given
        val arr = intArrayOf(10)

        //when
        val result = solution.solution(arr)

        //then
        assertThat(result).isEqualTo(intArrayOf(-1))
    }
}