package com.algorithm_proj.programmers.level1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class WeaponsForTemplerTest {

    @Test
    @DisplayName("number=5,limit=3,power=2일 때 결과는 10이다.")
    void t1() {
        assertThat(new WeaponsForTempler().solution(5,3,2)).isEqualTo(10);
    }

    @Test
    @DisplayName("number=10,limit=3,power=2일 때 결과는 21이다.")
    void t2() {
        assertThat(new WeaponsForTempler().solution(10,3,2)).isEqualTo(21);
    }

}