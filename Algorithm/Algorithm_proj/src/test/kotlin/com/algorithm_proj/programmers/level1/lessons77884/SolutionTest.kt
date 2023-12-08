package com.algorithm_proj.programmers.level1.lessons77884

import org.assertj.core.api.AssertionsForClassTypes
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun t1() {
        val result = solution.solution(13, 17)

        AssertionsForClassTypes.assertThat(result).isEqualTo(43)
    }

    @Test
    fun t2() {
        val result = solution.solution(24, 27)

        AssertionsForClassTypes.assertThat(result).isEqualTo(52)
    }
}