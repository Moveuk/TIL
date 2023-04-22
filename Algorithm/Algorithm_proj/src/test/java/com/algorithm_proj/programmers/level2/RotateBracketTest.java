package com.algorithm_proj.programmers.level2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RotateBracketTest {

    @Test
    @DisplayName("s = \"[](){}\", result = 3")
    public void t1() throws Exception {
        assertThat(new RotateBracket().solution("[](){}")).isEqualTo(3);
    }

    @Test
    @DisplayName("s = \"}]()[{\", result = 2")
    public void t2() throws Exception {
        assertThat(new RotateBracket().solution("}]()[{")).isEqualTo(2);
    }

    @Test
    @DisplayName("s = \"[)(]\", result = 0")
    public void t3() throws Exception {
        assertThat(new RotateBracket().solution("[)(]")).isEqualTo(0);
    }

    @Test
    @DisplayName("s = \"}}}\", result = 0")
    public void t4() throws Exception {
        assertThat(new RotateBracket().solution("}}}")).isEqualTo(0);
    }
}