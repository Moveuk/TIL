package com.algorithm_proj.programmers.level1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CokeProbTest {

    @Test
    @DisplayName("콜라 병 2개를 가져다 주면 1개로 바꿔줄 때 20개를 가져다주면 총 받는 콜라는 19개다.")
    void t1() {
        assertThat(new CokeProb().solution(2, 1, 20)).isEqualTo(19);
    }

    @Test
    @DisplayName("콜라 병 3개를 가져다 주면 1개로 바꿔줄 때 20개를 가져다주면 총 받는 콜라는 9개다.")
    void t2() {
        assertThat(new CokeProb().solution(3, 1, 20)).isEqualTo(9);
    }

    @Test
    @DisplayName("콜라 병 5개를 가져다 주면 3개로 바꿔줄 때 103개를 가져다주면 총 받는 콜라는 150개다.")
    void t3() {
        assertThat(new CokeProb().solution(5, 3, 103)).isEqualTo(150);
    }
}