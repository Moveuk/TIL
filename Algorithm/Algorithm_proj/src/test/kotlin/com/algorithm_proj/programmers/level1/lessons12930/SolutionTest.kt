package com.algorithm_proj.programmers.level1.lessons12930

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun t1() {
        //given
        val result = solution.solution("try hello world")

        //when

        //then
        assertThat(result).isEqualTo("TrY HeLlO WoRlD")
    }

    @Test
    fun t2() {
        //given
        val result = solution.solution("try  hello  world")

        //when

        //then
        assertThat(result).isEqualTo("TrY  HeLlO  WoRlD")
    }

    @Test
    fun t3() {
        //given
        val result = solution.solution("try  hello world  ")

        //when

        //then
        assertThat(result).isEqualTo("TrY  HeLlO WoRlD  ")
    }

    @Test
    fun t4() {
        //given
        val result = solution.solution("try    hr")

        //when

        //then
        assertThat(result).isEqualTo("TrY    Hr")
    }
}