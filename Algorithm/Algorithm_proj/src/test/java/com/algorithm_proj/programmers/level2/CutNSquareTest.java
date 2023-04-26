package com.algorithm_proj.programmers.level2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CutNSquareTest {

    @Test
    @DisplayName("n = 3, left = 2, right = 5, result = [3, 2, 2, 3]")
    public void t1() throws Exception {
        assertThat(new CutNSquare().solution(3, 2, 5)).isEqualTo(new int[]{3, 2, 2, 3});
    }

    @Test
    @DisplayName("n = 4, left = 7, right = 14, result = [4,3,3,3,4,4,4,4]")
    public void t2() throws Exception {
        assertThat(new CutNSquare().solution(4, 7, 14)).isEqualTo(new int[]{4,3,3,3,4,4,4,4});
    }
}