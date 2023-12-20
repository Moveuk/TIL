package com.algorithm_proj.programmers.level1.lessons12915

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `"sun", "bed", "car"와 1을 넣으면 "car", "bed", "sun"로 정렬된다`() {
        //given
        val result = solution.solution(arrayOf("sun", "bed", "car"), 1)

        //when

        //then
        assertThat(result).isEqualTo(arrayOf("car", "bed", "sun"))
    }

    @Test
    fun `"abce", "abcd", "cdx"와 2를 넣으면 "abcd", "abce", "cdx"정렬된다`() {
        //given
        val result = solution.solution(arrayOf("abce", "abcd", "cdx"), 2)

        //when

        //then
        assertThat(result).isEqualTo(arrayOf("abcd", "abce", "cdx"))
    }
}