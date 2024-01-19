package com.algorithm_proj.programmers.level1.lessons12947

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `x=10일 때 return=true이다`() {
        //given
        val x = 10
        val expect = true

        //when
        val result = solution.solution(x)

        //then
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `x=12일 때 return=true이다`() {
        //given
        val x = 12
        val expect = true

        //when
        val result = solution.solution(x)

        //then
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `x=11일 때 return=false이다`() {
        //given
        val x = 11
        val expect = false

        //when
        val result = solution.solution(x)

        //then
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `x=13일 때 return=false이다`() {
        //given
        val x = 13
        val expect = false

        //when
        val result = solution.solution(x)

        //then
        assertThat(result).isEqualTo(expect)
    }
}