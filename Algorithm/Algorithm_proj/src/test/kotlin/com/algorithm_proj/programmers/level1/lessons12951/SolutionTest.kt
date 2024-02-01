package com.algorithm_proj.programmers.level1.lessons12951

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `s="3people unFollowed me"일 때 return="3people Unfollowed Me"이다`() {
        //given
        val s = "3people unFollowed me"

        //when
        val result = solution.solution(s)

        //then
        assertThat(result).isEqualTo("3people Unfollowed Me")
    }

    @Test
    fun `s="for the last week"일 때 return="For The Last Week"이다`() {
        //given
        val s = "for the last week"

        //when
        val result = solution.solution(s)

        //then
        assertThat(result).isEqualTo("For The Last Week")
    }

    @Test
    fun `s="  for the what 1what  "일 때 return="  For The What 1what  "이다`() {
        //given
        val s = "for the last week"

        //when
        val result = solution.solution(s)

        //then
        assertThat(result).isEqualTo("For The Last Week")
    }
}