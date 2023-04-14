package com.algorithm_proj.programmers.level2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LeastCommonMultiplesTest {

    @Test
    @DisplayName("arr = [2, 6, 8, 14], result = 168")
    public void t1() throws Exception {
        assertThat(new LeastCommonMultiples().solution(new int[]{2,6,8,14})).isEqualTo(168);
    }

    @Test
    @DisplayName("arr = [1, 2, 3], result = 6")
    public void t2() throws Exception {
        assertThat(new LeastCommonMultiples().solution(new int[]{1, 2, 3})).isEqualTo(6);
    }

    @Test
    @DisplayName("arr = [12, 32, 45, 67, 72], result = 96480")
    public void t3() throws Exception {
        assertThat(new LeastCommonMultiples().solution(new int[]{12, 32, 45, 67, 72})).isEqualTo(96480);
    }

    @Test
    @DisplayName("arr = [17,34], result = 34")
    public void t4() throws Exception {
        assertThat(new LeastCommonMultiples().solution(new int[]{17,34})).isEqualTo(34);
    }

    @Test
    @DisplayName("arr = [13,17], result = 221")
    public void t5() throws Exception {
        assertThat(new LeastCommonMultiples().solution(new int[]{13,17})).isEqualTo(221);
    }
}