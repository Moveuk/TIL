package com.algorithm_proj.programmers.level0;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class DivisorTest {

    @Test
    @DisplayName("24의 약수는 [1, 2, 3, 4, 6, 8, 12, 24]이다.")
    void t1() {
        assertThat(new Divisor().solution(24)).isEqualTo(new int[]{1, 2, 3, 4, 6, 8, 12, 24});
    }

    @Test
    @DisplayName("29의 약수는 [1, 29]이다.")
    void t2() {
        assertThat(new Divisor().solution(29)).isEqualTo(new int[]{1, 29});
    }
}