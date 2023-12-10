package com.algorithm_proj.programmers.level1.lessons82612

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun t1() {
        //given
        val result = solution.solution(3, 20, 4)

        //when

        //then
        assertThat(result).isEqualTo(10)
    }
}
