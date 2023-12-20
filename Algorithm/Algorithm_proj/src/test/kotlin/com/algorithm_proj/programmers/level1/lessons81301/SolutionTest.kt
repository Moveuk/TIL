package com.algorithm_proj.programmers.level1.lessons81301

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `one4seveneight을 넣으면 1478이 된다`() {
        //given
        val result = solution.solution("one4seveneight")

        //when

        //then
        assertThat(result).isEqualTo(1478)
    }

    @Test
    fun `23four5six7 넣으면 234567이 된다`() {
        //given
        val result = solution.solution("23four5six7")

        //when

        //then
        assertThat(result).isEqualTo(234567)
    }

    @Test
    fun `2three45sixseven을 넣으면 234567이 된다`() {
        //given
        val result = solution.solution("2three45sixseven")

        //when

        //then
        assertThat(result).isEqualTo(234567)
    }

    @Test
    fun `123을 넣으면 123이 된다`() {
        //given
        val result = solution.solution("123")

        //when

        //then
        assertThat(result).isEqualTo(123)
    }
}