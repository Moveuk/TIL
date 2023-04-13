package com.algorithm_proj.programmers.level2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class JumpNTeleportTest {

    @Test
    @DisplayName("N = 5, result = 2")
    public void t1() throws Exception {
        assertThat(new JumpNTeleport().solution(5)).isEqualTo(2);
    }

    @Test
    @DisplayName("N = 6, result = 2")
    public void t2() throws Exception {
        assertThat(new JumpNTeleport().solution(6)).isEqualTo(2);
    }

    @Test
    @DisplayName("N = 5000, result = 5")
    public void t3() throws Exception {
        assertThat(new JumpNTeleport().solution(5000)).isEqualTo(5);
    }
}