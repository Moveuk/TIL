package com.algorithm_proj.programmers.level2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class Country124Test {

    @Test
    @DisplayName("n = 1, result = 1")
    public void t1() throws Exception {
        assertThat(new Country124().solution(1)).isEqualTo("1");
    }

    @Test
    @DisplayName("n = 2, result = 1")
    public void t2() throws Exception {
        assertThat(new Country124().solution(2)).isEqualTo("2");
    }

    @Test
    @DisplayName("n = 3, result = 1")
    public void t3() throws Exception {
        assertThat(new Country124().solution(3)).isEqualTo("4");
    }

    @Test
    @DisplayName("n = 4, result = 1")
    public void t4() throws Exception {
        assertThat(new Country124().solution(4)).isEqualTo("11");
    }

    @Test
    @DisplayName("n = 10, result = 41")
    public void t5() throws Exception {
        assertThat(new Country124().solution(10)).isEqualTo("41");
    }

}