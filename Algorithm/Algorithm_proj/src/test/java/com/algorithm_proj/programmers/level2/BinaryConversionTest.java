package com.algorithm_proj.programmers.level2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BinaryConversionTest {

    @Test
    @DisplayName("110010101001 -> [3,8]")
    public void t1() throws Exception {
        assertThat(new BinaryConversion().solution("110010101001")).isEqualTo(new int[]{3,8});
    }

    @Test
    @DisplayName("01110 -> [3,3]")
    public void t2() throws Exception {
        assertThat(new BinaryConversion().solution("01110")).isEqualTo(new int[]{3,3});
    }

    @Test
    @DisplayName("1111111 -> [4,1]")
    public void t3() throws Exception {
        assertThat(new BinaryConversion().solution("1111111")).isEqualTo(new int[]{4,1});
    }
}