package com.algorithm_proj.programmers.level1.lessons86491

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest{
    private val solution = Solution()

    @Test
    fun t1() {
        //given
        val result = solution.solution(arrayOf(intArrayOf(60, 50), intArrayOf(30, 70), intArrayOf(60, 30), intArrayOf(80, 40)))

        //when

        //then
        assertThat(result).isEqualTo(4000)
    }

    @Test
    fun t2() {
        //given
        val result = solution.solution(arrayOf(intArrayOf(10, 7), intArrayOf(12, 3), intArrayOf(8, 15), intArrayOf(14, 7), intArrayOf(5, 15)))

        //when

        //then
        assertThat(result).isEqualTo(120)
    }

    @Test
    fun t3() {
        //given
        val result = solution.solution(arrayOf(intArrayOf(14, 4), intArrayOf(19, 6), intArrayOf(6, 16), intArrayOf(18, 7), intArrayOf(7, 11)))

        //when

        //then
        assertThat(result).isEqualTo(133)
    }
}