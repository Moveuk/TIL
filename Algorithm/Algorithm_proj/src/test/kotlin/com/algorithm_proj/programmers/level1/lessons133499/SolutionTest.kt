package com.algorithm_proj.programmers.level1.lessons133499

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `babbling={"aya", "yee", "u", "maa"}일 떄 result=1이다`() {
        //given
        val result = solution.solution(arrayOf("aya", "yee", "u", "maa"))

        //when

        //then
        assertThat(result).isEqualTo(1)
    }

    @Test
    fun `babbling={"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"}일 떄 result=2이다`() {
        //given
        val result = solution.solution(arrayOf("ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"))

        //when

        //then
        assertThat(result).isEqualTo(2)
    }
}