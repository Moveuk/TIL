package com.algorithm_proj.programmers.level2.lessons42578

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `test1`() {
        //given
        val clothes = arrayOf(arrayOf("yellow_hat", "headgear"), arrayOf("blue_sunglasses", "eyewear"), arrayOf("green_turban", "headgear"))
        val expect = 5

        //when
        val result = solution.solution(clothes)

        //then
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `test2`() {
        //given
        val clothes = arrayOf(arrayOf("crow_mask", "face"), arrayOf("blue_sunglasses", "face"), arrayOf("smoky_makeup", "face"))
        val expect = 3

        //when
        val result = solution.solution(clothes)

        //then
        assertThat(result).isEqualTo(expect)
    }
}