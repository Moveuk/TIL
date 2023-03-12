package com.algorithm_proj.programmers.level0;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BacterialGrowthTest {

    @Test
    @DisplayName("n이 2이고 t가 10일때 결과는 2048이다.")
    void t1() {
        assertThat(new BacterialGrowth().solution(2, 10)).isEqualTo(2048);
    }

    @Test
    @DisplayName("n이 7이고 t가 15일때 결과는 229376이다.")
    void t2() {
        assertThat(new BacterialGrowth().solution(7, 15)).isEqualTo(229376);
    }
}