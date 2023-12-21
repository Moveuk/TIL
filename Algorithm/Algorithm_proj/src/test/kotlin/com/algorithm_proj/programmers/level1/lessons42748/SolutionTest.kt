package com.algorithm_proj.programmers.level1.lessons42748

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()
    
    @Test
    fun `배열 {1, 5, 2, 6, 3, 7, 4}와 {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}를 넣었을 때 배열 {5, 6, 3}가 나와야 한다`() {
        //given
        val result = solution.solution(intArrayOf(1, 5, 2, 6, 3, 7, 4), arrayOf(intArrayOf(2, 5, 3), intArrayOf(4, 4, 1), intArrayOf(1, 7, 3)))
        
        //when
    
        //then
        assertThat(result).isEqualTo(intArrayOf(5, 6, 3))
    }
}