package com.algorithm_proj.programmers.level1.lessons155652

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `s="aukks", skip="wbqd", index=5일 때 result="happy"이다`() {
        //given
        val result = solution.solution("aukks", "wbqd", 5)

        //when

        //then
        assertThat(result).isEqualTo("happy")
    }

    @Test
    fun `s="a", skip="bcdefghijk", index=20일 때 result="happy"이다`() {
        //given
        val result = solution.solution("a", "bcdefghijk", 20)

        //when

        //then
        assertThat(result).isEqualTo("o")
    }
}