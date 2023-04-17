package com.algorithm_proj.programmers.level2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LongJumpTest {

    @Test
    @DisplayName("n=4, result 5")
    public void t1() throws Exception {
        assertThat(new LongJump().solution(4)).isEqualTo(5);
    }

    @Test
    @DisplayName("n=3, result 3")
    public void t2() throws Exception {
        assertThat(new LongJump().solution(3)).isEqualTo(3);
    }
}