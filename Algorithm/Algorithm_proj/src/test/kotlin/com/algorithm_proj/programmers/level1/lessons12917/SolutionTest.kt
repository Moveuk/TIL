package com.algorithm_proj.programmers.level1.lessons12917

import org.assertj.core.api.AssertionsForClassTypes
import org.junit.jupiter.api.Test


class SolutionTest{
    private val solution = Solution()

    @Test
    fun t1() {
        val result = solution.solution("Zbcdefg")

        AssertionsForClassTypes.assertThat(result).isEqualTo("gfedcbZ")
    }
}