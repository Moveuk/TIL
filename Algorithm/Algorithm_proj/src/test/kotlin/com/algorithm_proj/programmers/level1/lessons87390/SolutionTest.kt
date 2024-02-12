package com.algorithm_proj.programmers.level1.lessons87390

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `n=3, left=2, right=5, result={3,2,2,3}`() {
        //given
        val n = 3
        val left = 2L
        val right = 5L
        val expect = intArrayOf(3, 2, 2, 3)

        //when
        val result = solution.solution(n, left, right)

        //then
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `n=4, left=7, right=14, result={4,3,3,3,4,4,4,4}`() {
        //given
        val n = 4
        val left = 7L
        val right = 14L
        val expect = intArrayOf(4,3,3,3,4,4,4,4)

        //when
        val result = solution.solution(n, left, right)

        //then
        assertThat(result).isEqualTo(expect)
    }
}