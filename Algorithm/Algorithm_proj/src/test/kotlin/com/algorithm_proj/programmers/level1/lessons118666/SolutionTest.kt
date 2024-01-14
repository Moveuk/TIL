package com.algorithm_proj.programmers.level1.lessons118666

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `survey={"AN", "CF", "MJ", "RT", "NA"}, choices={5, 3, 2, 7, 5}일 때 result="TCMA"이다`() {
        //given
        val result = solution.solution(arrayOf("AN", "CF", "MJ", "RT", "NA"), intArrayOf(5, 3, 2, 7, 5))

        //when

        //then
        assertThat(result).isEqualTo("TCMA")
    }

    @Test
    fun `survey={"TR", "RT", "TR"}, choices={7, 1, 3}일 때 result="RCJA"이다`() {
        //given
        val result = solution.solution(arrayOf("TR", "RT", "TR"), intArrayOf(7, 1, 3))

        //when

        //then
        assertThat(result).isEqualTo("RCJA")
    }
}