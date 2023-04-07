package com.algorithm_proj.programmers.level2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LifeboatTest {

    @Test
    @DisplayName("people = [70, 50, 80, 50], limit = 100 / return = 3")
    public void t1() throws Exception {
        assertThat(new Lifeboat().solution(new int[]{70, 50, 80, 50}, 100)).isEqualTo(3);
    }

    @Test
    @DisplayName("people = [70, 80, 50], limit = 100 / return = 3")
    public void t2() throws Exception {
        assertThat(new Lifeboat().solution(new int[]{70, 80, 50}, 100)).isEqualTo(3);
    }

    @Test
    @DisplayName("people = [70, 80, 50, 45, 45, 60], limit = 100 / return = 5")
    public void t3() throws Exception {
        assertThat(new Lifeboat().solution(new int[]{70, 80, 50, 45, 45, 60}, 100)).isEqualTo(5);
    }

    @Test
    @DisplayName("people = [70, 80, 50, 45, 60, 30,40,65,15,97,65,34,76,54], limit = 100 / return = 9")
    public void t4() throws Exception {
        assertThat(new Lifeboat().solution(new int[]{70, 80, 50, 45, 60, 30, 40, 65, 15, 97, 65, 34, 76, 54}, 100)).isEqualTo(9);
    }

    @Test
    @DisplayName("people = [160, 160, 160, 50, 40], limit = 200 / return = 4")
    public void t5() throws Exception {
        assertThat(new Lifeboat().solution(new int[]{160, 160, 160, 50, 40}, 200)).isEqualTo(4);
    }
}