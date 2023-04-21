package com.algorithm_proj.programmers.level2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ChooseTangTest {

    @Test
    @DisplayName("k = 6, tangerine = [1, 3, 2, 5, 4, 5, 2, 3], result = 3")
    public void t1() throws Exception {
        assertThat(new ChooseTang().solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3})).isEqualTo(3);
    }

    @Test
    @DisplayName("k = 4, tangerine = [1, 3, 2, 5, 4, 5, 2, 3], result = 2")
    public void t2() throws Exception {
        assertThat(new ChooseTang().solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3})).isEqualTo(2);
    }

    @Test
    @DisplayName("k = 2, tangerine = [1, 1, 1, 1, 2, 2, 2, 3], result = 1")
    public void t3() throws Exception {
        assertThat(new ChooseTang().solution(2, new int[]{1, 3, 2, 5, 4, 5, 2, 3})).isEqualTo(1);
    }
}