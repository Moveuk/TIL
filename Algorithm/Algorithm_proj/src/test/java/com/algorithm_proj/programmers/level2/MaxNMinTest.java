package com.algorithm_proj.programmers.level2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MaxNMinTest {

    @Test
    @DisplayName("s=1 2 3 4, return 1 4")
    void t1() {
        assertThat(new MaxNMin().solution("1 2 3 4")).isEqualTo("1 4");
    }

    @Test
    @DisplayName("s=-1 -2 -3 -4, return -4 -1")
    void t2() {
        assertThat(new MaxNMin().solution("-1 -2 -3 -4")).isEqualTo("-4 -1");
    }

    @Test
    @DisplayName("s=-1 -1, return -1 -1")
    void t3() {
        assertThat(new MaxNMin().solution("-1 -1")).isEqualTo("-1 -1");
    }
}