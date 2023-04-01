package com.algorithm_proj.programmers.level2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ExpNumberTest {

    @Test
    @DisplayName("n=15, result=4")
    public void t1() throws Exception {
        assertThat(new ExpNumber().solution(15)).isEqualTo(4);
    }

}