package com.algorithm_proj.programmers.level2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class DeletePairsTest {

    @Test
    @DisplayName("s = baabaa, result = 1")
    public void t1() throws Exception {
        assertThat(new DeletePairs().solution("baabaa")).isEqualTo(1);
    }

    @Test
    @DisplayName("s = cdcd, result = 1")
    public void t2() throws Exception {
        assertThat(new DeletePairs().solution("cdcd")).isEqualTo(0);
    }

    @Test
    @DisplayName("s = a, result = 0")
    public void t3() throws Exception {
        assertThat(new DeletePairs().solution("a")).isEqualTo(0);
    }

    @Test
    @DisplayName("s = aaaaa, result = 0")
    public void t4() throws Exception {
        assertThat(new DeletePairs().solution("aaaaa")).isEqualTo(0);
    }

    @Test
    @DisplayName("s = aaaaab, result = 0")
    public void t5() throws Exception {
        assertThat(new DeletePairs().solution("aaaaab")).isEqualTo(0);
    }
}