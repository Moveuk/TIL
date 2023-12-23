package com.algorithm_proj.programmers.level1.lessons142086

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `banana를 넣으면 배열{-1, -1, -1, 2, 2, 2}가 나온다`() {
        //given
        val result = solution.solution("banana")

        //when

        //then
        assertThat(result).isEqualTo(intArrayOf(-1, -1, -1, 2, 2, 2))
    }

    @Test
    fun `foobar를 넣으면 배열{-1, -1, 1, -1, -1, -1}가 나온다`() {
        //given
        val result = solution.solution("foobar")

        //when

        //then
        assertThat(result).isEqualTo(intArrayOf(-1, -1, 1, -1, -1, -1))
    }
}