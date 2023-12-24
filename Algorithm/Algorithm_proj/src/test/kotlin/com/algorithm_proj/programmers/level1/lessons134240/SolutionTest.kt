package com.algorithm_proj.programmers.level1.lessons134240

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `배열 {1, 3, 4, 6}를 넣었을때 "1223330333221"가 나와야 한다`() {
        //given
        val result = solution.solution(intArrayOf(1, 3, 4, 6))

        //when

        //then
        assertThat(result).isEqualTo("1223330333221")
    }

    @Test
    fun `배열 {1, 7, 1, 2}를 넣었을때 "111303111"가 나와야 한다`() {
        //given
        val result = solution.solution(intArrayOf(1, 7, 1, 2))

        //when

        //then
        assertThat(result).isEqualTo("111303111")
    }
}