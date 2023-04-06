package com.algorithm_proj.programmers.level2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarpetTest {

    @Test
    @DisplayName("brown = 10, yellow = 2, return [4,3]")
    public void t1() throws Exception {
        assertThat(new Carpet().solution(10, 2)).isEqualTo(new int[]{4,3});
    }

    @Test
    @DisplayName("brown = 8, yellow = 1, return [3,3]")
    public void t2() throws Exception {
        assertThat(new Carpet().solution(8, 1)).isEqualTo(new int[]{3,3});
    }

    @Test
    @DisplayName("brown = 24, yellow = 24, return [8,6]")
    public void t3() throws Exception {
        assertThat(new Carpet().solution(24, 24)).isEqualTo(new int[]{8,6});
    }

    @Test
    @DisplayName("brown = 18, yellow = 6, return [8,3]")
    public void t4() throws Exception {
        assertThat(new Carpet().solution(18, 6)).isEqualTo(new int[]{8,3});
    }

    @Test
    @DisplayName("brown = 16, yellow = 8, return [6,4]")
    public void t5() throws Exception {
        assertThat(new Carpet().solution(16, 8)).isEqualTo(new int[]{6,4});
    }
}