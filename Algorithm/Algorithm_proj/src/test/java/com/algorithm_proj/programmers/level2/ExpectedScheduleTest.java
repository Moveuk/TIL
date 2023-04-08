package com.algorithm_proj.programmers.level2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ExpectedScheduleTest {

    @Test
    @DisplayName("N = 8, A = 4 ,B = 7/ answer = 3")
    public void t() throws Exception {
        assertThat(new ExpectedSchedule().solution(8, 4, 7)).isEqualTo(3);
    }

}