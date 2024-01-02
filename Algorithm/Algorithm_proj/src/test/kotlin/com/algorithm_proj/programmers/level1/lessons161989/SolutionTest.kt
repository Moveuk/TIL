package com.algorithm_proj.programmers.level1.lessons161989

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `n=8, m=4, section={2, 3, 6}일 때 결과는 2이다`() {
        //given
        val result = solution.solution(8, 4, intArrayOf(2, 3, 6))

        //when

        //then
        assertThat(result).isEqualTo(2)
    }

    @Test
    fun `n=5, m=4, section={1, 3}일 때 결과는 1이다`() {
        //given
        val result = solution.solution(5, 4, intArrayOf(1, 3))

        //when

        //then
        assertThat(result).isEqualTo(1)
    }

    @Test
    fun `n=4, m=1, section={1,2,3,4}일 때 결과는 4이다`() {
        //given
        val result = solution.solution(4, 1, intArrayOf(1, 2, 3, 4))

        //when

        //then
        assertThat(result).isEqualTo(4)
    }
}