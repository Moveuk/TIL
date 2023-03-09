package com.algorithm_proj.programmers.level0;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TDDTest {

    @Test
    @DisplayName("TDD 테스트")
    void t1() {
        assertThat(new TDD().solution(1)).isEqualTo(1);
    }
}
