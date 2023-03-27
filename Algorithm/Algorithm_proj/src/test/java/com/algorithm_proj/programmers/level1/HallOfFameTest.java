package com.algorithm_proj.programmers.level1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class HallOfFameTest {

    @Test
    @DisplayName("k = 3, score [10, 100, 20, 150, 1, 100, 200] -> result = [10, 10, 10, 20, 20, 100, 100]")
    void t1() {
        assertThat(new HallOfFame()
                .solution(3, new int[]{10, 100, 20, 150, 1, 100, 200}))
                .isEqualTo(new int[]{10, 10, 10, 20, 20, 100, 100});
    }

    @Test
    @DisplayName("k = 4, score [0, 300, 40, 300, 20, 70, 150, 50, 500, 1000] -> result = [0, 0, 0, 0, 20, 40, 70, 70, 150, 300]")
    void t2() {
        assertThat(new HallOfFame()
                .solution(4, new int[]{0, 300, 40, 300, 20, 70, 150, 50, 500, 1000}))
                .isEqualTo(new int[]{0, 0, 0, 0, 20, 40, 70, 70, 150, 300});
    }

}