package com.algorithm_proj.programmers.level1.lessons12922

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun t1() {
        val result = solution.solution(3)

        assertThat(result).isEqualTo("수박수")
    }

    @Test
    fun t2() {
        val result = solution.solution(4)

        assertThat(result).isEqualTo("수박수박")
    }
}