package com.algorithm_proj.programmers.level2.lessons42842

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `brown=10, yellow=2일 때 return={4, 3}`() {
        //given
        val brown = 10
        val yellow = 2
        val expect = intArrayOf(4, 3)

        //when
        val result = solution.solution(brown, yellow)

        //then
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `brown=8, yellow=1일 때 return={3, 3}`() {
        //given
        val brown = 8
        val yellow = 1
        val expect = intArrayOf(3, 3)

        //when
        val result = solution.solution(brown, yellow)

        //then
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `brown=24, yellow=24일 때 return={8, 6}`() {
        //given
        val brown = 24
        val yellow = 24
        val expect = intArrayOf(8, 6)

        //when
        val result = solution.solution(brown, yellow)

        //then
        assertThat(result).isEqualTo(expect)
    }
}