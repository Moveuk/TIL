package com.algorithm_proj.programmers.level1.lessons68644

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `배열{2,1,3,4,1}을 넣으면 배열{2,3,4,5,6,7}가 나온다`() {
        //given
        val result = solution.solution(intArrayOf(2,1,3,4,1))

        //when

        //then
        assertThat(result).isEqualTo(intArrayOf(2,3,4,5,6,7))
    }

    @Test
    fun `배열{5,0,2,7}을 넣으면 배열{2,5,7,9,12}가 나온다`() {
        //given
        val result = solution.solution(intArrayOf(5,0,2,7))

        //when

        //then
        assertThat(result).isEqualTo(intArrayOf(2,5,7,9,12))
    }
}