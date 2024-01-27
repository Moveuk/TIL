package com.algorithm_proj.programmers.level1.lessons12948

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `phone_number = "01033334444"일 때 return = "*******4444"`() {
        //given
        val phone_number = "01033334444"

        //when
        val result = solution.solution(phone_number)

        //then
        assertThat(result).isEqualTo("*******4444")
    }

    @Test
    fun `phone_number = "027778888"일 때 return = "*****8888"`() {
        //given
        val phone_number = "027778888"

        //when
        val result = solution.solution(phone_number)

        //then
        assertThat(result).isEqualTo("*****8888")
    }
}