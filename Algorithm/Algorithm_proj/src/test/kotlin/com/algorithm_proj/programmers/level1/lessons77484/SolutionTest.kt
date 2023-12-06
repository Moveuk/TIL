package com.algorithm_proj.programmers.level1.lessons77484

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test

internal class SolutionTest {
    private val solution = Solution()

    @Test
    fun t1() {
        val result = solution.solution(intArrayOf(44, 1, 0, 0, 31, 25), intArrayOf(31, 10, 45, 1, 6, 19))

        assertThat(result).isEqualTo(intArrayOf(3, 5))
    }

    @Test
    fun t2() {
        val result = solution.solution(intArrayOf(0, 0, 0, 0, 0, 0), intArrayOf(38, 19, 20, 40, 15, 25))

        assertThat(result).isEqualTo(intArrayOf(1, 6))
    }

    @Test
    fun t3() {
        val result = solution.solution(intArrayOf(44, 1, 0, 0, 31, 25), intArrayOf(31, 10, 45, 1, 6, 19))

        assertThat(result).isEqualTo(intArrayOf(3, 5))
    }
}