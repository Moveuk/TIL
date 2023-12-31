package com.algorithm_proj.programmers.level1.lessons12977

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `nums={1, 2, 3, 4}를 넣으면 result는 1이다`() {
        //given
        val result = solution.solution(intArrayOf(1, 2, 3, 4))

        //when

        //then
        assertThat(result).isEqualTo(1)
    }

    @Test
    fun `nums={1,2,7,6,4}를 넣으면 result는 4이다`() {
        //given
        val result = solution.solution(intArrayOf(1,2,7,6,4))

        //when

        //then
        assertThat(result).isEqualTo(4)
    }

    @Test
    fun `nums={1, 2, 8, 4, 5}를 넣으면 result는 5이다`() {
        //given
        val result = solution.solution(intArrayOf(1, 2, 8, 4, 5))

        //when

        //then
        assertThat(result).isEqualTo(5)
    }
}