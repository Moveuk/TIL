package com.algorithm_proj.programmers.level1.lessons138477

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `k=3 score={10, 100, 20, 150, 1, 100, 200}을 넣으면 결과는 result={10, 10, 10, 20, 20, 100, 100}이다`() {
        //given
        val result = solution.solution(3, intArrayOf(10, 100, 20, 150, 1, 100, 200))

        //when

        //then
        assertThat(result).isEqualTo(intArrayOf(10, 10, 10, 20, 20, 100, 100))
    }

    @Test
    fun `k=4 score={0, 300, 40, 300, 20, 70, 150, 50, 500, 1000}을 넣으면 결과는 result={0, 0, 0, 0, 20, 40, 70, 70, 150, 300}이다`() {
        //given
        val result = solution.solution(4, intArrayOf(0, 300, 40, 300, 20, 70, 150, 50, 500, 1000))

        //when

        //then
        assertThat(result).isEqualTo(intArrayOf(0, 0, 0, 0, 20, 40, 70, 70, 150, 300))
    }
}