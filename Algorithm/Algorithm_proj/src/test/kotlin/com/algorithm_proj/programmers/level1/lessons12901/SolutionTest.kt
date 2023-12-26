package com.algorithm_proj.programmers.level1.lessons12901

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `a=5, b=24이면 result는 "TUE"이다`() {
        //given
        val result = solution.solution(5, 24)

        //when

        //then
        assertThat(result).isEqualTo("TUE")
    }
}