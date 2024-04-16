package com.algorithm_proj.programmers.level2.lessons87946

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()
    @Test
    fun `k=80, dungeons={{80, 20},{50, 40},{30, 10}}일 때 result=3이다`() {
        //given
        val k = 80
        val dungeons = arrayOf(intArrayOf(80, 20), intArrayOf(50, 40), intArrayOf(30, 10),)

        //when
        val result = solution.solution(k, dungeons)

        //then
        assertThat(result).isEqualTo(3)
    }
}