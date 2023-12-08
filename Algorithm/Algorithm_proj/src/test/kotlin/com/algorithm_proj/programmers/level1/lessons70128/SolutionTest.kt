package com.algorithm_proj.programmers.level1.lessons70128

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun t1() {
        val result = solution.solution(intArrayOf(1,2,3,4), intArrayOf(-3,-1,0,2))

        assertThat(result).isEqualTo(3)
    }

    @Test
    fun t2() {
        val result = solution.solution(intArrayOf(-1,0,1), intArrayOf(1,0,-1))

        assertThat(result).isEqualTo(-2)
    }
}