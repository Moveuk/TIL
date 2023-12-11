package com.algorithm_proj.programmers.level1.lessons12950

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun t1() {
        //given
        val result = solution.solution(arrayOf(intArrayOf(1,2), intArrayOf(2,3)),arrayOf(intArrayOf(3,4), intArrayOf(5,6)))

        //when

        //then
        assertThat(result).isEqualTo(arrayOf(intArrayOf(4,6), intArrayOf(7,9)))
    }
    @Test
    fun t2() {
        //given
        val result = solution.solution(arrayOf(intArrayOf(1), intArrayOf(2)),arrayOf(intArrayOf(3), intArrayOf(4)))

        //when

        //then
        assertThat(result).isEqualTo(arrayOf(intArrayOf(4), intArrayOf(6)))
    }
}