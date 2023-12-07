package com.algorithm_proj.programmers.level0.lessons120804

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun t1() {
        val result = solution.solution(3, 4)
        val expected = 12
        assertEquals(expected, result)
    }

    @Test
    fun t2() {
        val result = solution.solution(27, 19)
        val expected = 513
        assertEquals(expected, result)
    }
}