package com.algorithm_proj.programmers.level0.lessons120803

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SolutionTest {
    private val solution = Solution()

    @Test
    fun t1() {
        val result = solution.solution(2, 3)
        val expected = -1
        assertEquals(expected, result)
    }

    @Test
    fun t2() {
        val result = solution.solution(100, 2)
        val expected = 98
        assertEquals(expected, result)
    }
}