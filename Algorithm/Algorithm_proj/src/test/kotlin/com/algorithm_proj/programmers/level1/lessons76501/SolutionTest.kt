package com.algorithm_proj.programmers.level1.lessons76501

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `absolutes={4, 7, 12}, signs={true, false, true}일 때 result=9`() {
        //given
        val absolutes = intArrayOf(4, 7, 12)
        val signs = booleanArrayOf(true, false, true)

        //when
        val result = solution.solution(absolutes, signs)

        //then
        assertThat(result).isEqualTo(9)
    }

    @Test
    fun `absolutes={1,2,3}, signs={false,false,true}일 때 result=0`() {
        //given
        val absolutes = intArrayOf(1,2,3)
        val signs = booleanArrayOf(false,false,true)

        //when
        val result = solution.solution(absolutes, signs)

        //then
        assertThat(result).isEqualTo(0)
    }
}