package com.algorithm_proj.programmers.level1.lessons131127

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `want, number, discount일 때 result는 3이다`() {
        //given
        val want = arrayOf("banana", "apple", "rice", "pork", "pot")
        val number = intArrayOf(3, 2, 2, 2, 1)
        val discount = arrayOf("chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana")
        val expect = 3

        //when
        val result = solution.solution(want, number, discount)

        //then
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `want, number, discount일 때 result는 0이다`() {
        //given
        val want = arrayOf("apple")
        val number = intArrayOf(10)
        val discount = arrayOf("banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana")
        val expect = 0

        //when
        val result = solution.solution(want, number, discount)

        //then
        assertThat(result).isEqualTo(expect)
    }
}