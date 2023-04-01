package com.algorithm_proj.programmers.level2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NextBigNumberTest {

    @Test
    @DisplayName("n=78, result=83")
    public void t1() throws Exception {
        assertThat(new NextBigNumber().solution(78)).isEqualTo(83);
    }

    @Test
    @DisplayName("n=15, result=23")
    public void t2() throws Exception {
        assertThat(new NextBigNumber().solution(15)).isEqualTo(23);
    }

    @Test
    @DisplayName("n=1000000, result=23")
    public void t3() throws Exception {
        assertThat(new NextBigNumber().solution(1000000)).isEqualTo(1000064);
    }
}