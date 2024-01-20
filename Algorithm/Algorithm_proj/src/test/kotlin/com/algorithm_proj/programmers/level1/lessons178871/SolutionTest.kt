package com.algorithm_proj.programmers.level1.lessons178871

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()
    
    @Test
    fun `players={"mumu", "soe", "poe", "kai", "mine"}이고 callings={"kai", "kai", "mine", "mine"}일 때 result={"mumu", "kai", "mine", "soe", "poe"}이다`() {
        //given
        val players = arrayOf("mumu", "soe", "poe", "kai", "mine")
        val callings = arrayOf("kai", "kai", "mine", "mine")
        val expect = arrayOf("mumu", "kai", "mine", "soe", "poe")

        //when
        val result = solution.solution(players, callings)
    
        //then
        assertThat(result).isEqualTo(expect)
    }
}