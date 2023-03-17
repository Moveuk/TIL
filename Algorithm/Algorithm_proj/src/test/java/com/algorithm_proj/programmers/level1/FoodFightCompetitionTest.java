package com.algorithm_proj.programmers.level1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class FoodFightCompetitionTest {

    @Test
    @DisplayName("[1, 3, 4, 6] food면 1223330333221이다.")
    void t1() {
        assertThat(new FoodFightCompetition().solution(new int[]{1, 3, 4, 6})).isEqualTo("1223330333221");
    }

    @Test
    @DisplayName("[1, 7, 1, 2] food면 111303111.")
    void t2() {
        assertThat(new FoodFightCompetition().solution(new int[]{1, 7, 1, 2})).isEqualTo("111303111");
    }
}