package com.algorithm_proj.programmers.level2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SumOfSequenceTest {
    
    @Test
    @DisplayName("elements = [7,9,1,1,4], result = 18")
    public void t1() throws Exception {
        assertThat(new SumOfSequence().solution(new int[]{7,9,1,1,4})).isEqualTo(18);
    }
}