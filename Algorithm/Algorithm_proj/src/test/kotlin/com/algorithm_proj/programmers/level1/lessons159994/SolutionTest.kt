package com.algorithm_proj.programmers.level1.lessons159994

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `cards1={"i", "drink", "water"} cards2={"want", "to"} goal={"i", "want", "to", "drink", "water"}일 때 result는 "Yes"이다`() {
        //given
        val result = solution.solution(
            arrayOf("i", "drink", "water"),
            arrayOf("want", "to"),
            arrayOf("i", "want", "to", "drink", "water")
        )

        //when

        //then
        assertThat(result).isEqualTo("Yes")
    }

    @Test
    fun `cards1={"i", "water", "drink"} cards2={"want", "to"} goal={"i", "want", "to", "drink", "water"}일 때 result는 "Yes"이다`() {
        //given
        val result = solution.solution(
            arrayOf("i", "water", "drink"),
            arrayOf("want", "to"),
            arrayOf("i", "want", "to", "drink", "water")
        )

        //when

        //then
        assertThat(result).isEqualTo("No")
    }
}