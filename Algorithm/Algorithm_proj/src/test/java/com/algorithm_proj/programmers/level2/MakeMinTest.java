package com.algorithm_proj.programmers.level2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MakeMinTest {

    @Test
    @DisplayName("[1, 4, 2],[5, 4, 4] return 29")
    void t1() {
        assertThat(new MakeMin()
                .solution(new int[]{1, 4, 2}, new int[]{5, 4, 4}))
                .isEqualTo(29);
    }

    @Test
    @DisplayName("[1, 2],[3, 4] return 10")
    void t2() {
        assertThat(new MakeMin()
                .solution(new int[]{1, 2}, new int[]{3, 4}))
                .isEqualTo(10);
    }

}