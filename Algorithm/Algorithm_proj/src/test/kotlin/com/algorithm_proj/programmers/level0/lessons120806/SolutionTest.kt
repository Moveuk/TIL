package com.algorithm_proj.programmers.level0.lessons120806

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `3에서 2를 나눈 값에 1000을 곱한 정수부분은 1500이다`() {
        //given
        val result = solution.solution(3, 2)

        //when

        //then
        assertThat(result).isEqualTo(1500)
    }

    @Test
    fun `7에서 3를 나눈 값에 1000을 곱한 정수부분은 2333이다`() {
        //given
        val result = solution.solution(7, 3)

        //when

        //then
        assertThat(result).isEqualTo(2333)
    }

    @Test
    fun `1에서 16를 나눈 값에 1000을 곱한 정수부분은 62이다`() {
        //given
        val result = solution.solution(1, 16)

        //when

        //then
        assertThat(result).isEqualTo(62)
    }
}