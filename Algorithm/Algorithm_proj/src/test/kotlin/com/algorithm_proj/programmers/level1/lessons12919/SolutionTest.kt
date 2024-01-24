package com.algorithm_proj.programmers.level1.lessons12919

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `seoul={"Jane", "Kim"}일 때 return="김서방은 1에 있다"`() {
        //given
        val seoul = arrayOf("Jane", "Kim")

        //when
        val result = solution.solution(seoul)

        //then
        assertThat(result).isEqualTo("김서방은 1에 있다")
    }
}