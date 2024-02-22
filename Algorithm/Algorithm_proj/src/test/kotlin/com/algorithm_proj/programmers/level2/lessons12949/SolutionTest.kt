package com.algorithm_proj.programmers.level2.lessons12949

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `test1`() {
        //given
        val arr1 = arrayOf(intArrayOf(1, 4), intArrayOf(3, 2), intArrayOf(4, 1))
        val arr2 = arrayOf(intArrayOf(3, 3), intArrayOf(3, 3))
        val expect = arrayOf(intArrayOf(15, 15), intArrayOf(15, 15), intArrayOf(15, 15))

        //when
        val result = solution.solution(arr1, arr2)

        //then
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `test2`() {
        //given
        val arr1 = arrayOf(intArrayOf(2, 3, 2), intArrayOf(4, 2, 4), intArrayOf(3, 1, 4))
        val arr2 = arrayOf(intArrayOf(5, 4, 3), intArrayOf(2, 4, 1), intArrayOf(3, 1, 1))
        val expect = arrayOf(intArrayOf(22, 22, 11), intArrayOf(36, 28, 18), intArrayOf(29, 20, 14))

        //when
        val result = solution.solution(arr1, arr2)

        //then
        assertThat(result).isEqualTo(expect)
    }
}