package com.algorithm_proj.programmers.level1.lessons12933

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()
    
    @Test
    fun `n=118372일 때 return=873211이다`() {
        //given
        val result = solution.solution(118372)
        
        //when
    
        //then
        assertThat(result).isEqualTo(873211)
    }
}