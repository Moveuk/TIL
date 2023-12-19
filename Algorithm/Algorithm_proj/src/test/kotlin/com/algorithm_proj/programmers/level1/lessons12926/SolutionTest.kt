package com.algorithm_proj.programmers.level1.lessons12926

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun t1() {
        //given
        val result = solution.solution("AB", 1)

        //when

        //then
        assertThat(result).isEqualTo("BC")
    }

    @Test
    fun t2() {
        //given
        val result = solution.solution("z", 1)

        //when

        //then
        assertThat(result).isEqualTo("a")
    }

    @Test
    fun t3() {
        //given
        val result = solution.solution("a B z", 4)

        //when

        //then
        assertThat(result).isEqualTo("e F d")
    }
}