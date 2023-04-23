package com.algorithm_proj.programmers.level2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class H_IndexTest {
    
    @Test
    @DisplayName("citations = [3, 0, 6, 1, 5], return 3")
    public void t1() throws Exception {
        assertThat(new H_Index().solution(new int[]{3, 0, 6, 1, 5})).isEqualTo(3);
    }
}