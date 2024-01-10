package com.algorithm_proj.programmers.level1.lessons160586

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `keymap={"ABACD", "BCEFD"}, targets={"ABCD", "AABB"}일 때 result={9, 4}이다`() {
        //given
        val result = solution.solution(arrayOf("ABACD", "BCEFD"), arrayOf("ABCD", "AABB"))

        //when

        //then
        assertThat(result).isEqualTo(intArrayOf(9, 4))
    }

    @Test
    fun `keymap={"AA"}, targets={"B"}일 때 result={-1}이다`() {
        //given
        val result = solution.solution(arrayOf("AA"), arrayOf("B"))

        //when

        //then
        assertThat(result).isEqualTo(intArrayOf(-1))
    }

    @Test
    fun `keymap={"AGZ", "BSSS"}, targets={"ASA","BGZ"}일 때 result={4, 6}이다`() {
        //given
        val result = solution.solution(arrayOf("AGZ", "BSSS"), arrayOf("ASA","BGZ"))

        //when

        //then
        assertThat(result).isEqualTo(intArrayOf(4, 6))
    }

    @Test
    fun `keymap={"AB", "BA"}, targets={"AA"}일 때 result={2}이다`() {
        //given
        val result = solution.solution(arrayOf("AB", "BA"), arrayOf("AA"))

        //when

        //then
        assertThat(result).isEqualTo(intArrayOf(2))
    }

    @Test
    fun `keymap={"ABCDEFGHIJ"}, targets={"JJJJJJJJJJJ"}일 때 result={110}이다`() {
        //given
        val result = solution.solution(arrayOf("ABCDEFGHIJ"), arrayOf("JJJJJJJJJJJ"))

        //when

        //then
        assertThat(result).isEqualTo(intArrayOf(110))
    }

    @Test
    fun `keymap={"ABC"}, targets={"XA"}일 때 result={-1}이다`() {
        //given
        val result = solution.solution(arrayOf("ABC"), arrayOf("XA"))

        //when

        //then
        assertThat(result).isEqualTo(intArrayOf(-1))
    }
}