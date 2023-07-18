package com.algorithm_proj.programmers.level2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class DevFuncTest {

    @Test
    @DisplayName("progresses = {93, 30, 55}, speeds = {1, 30, 5}, result = {2, 1}")
    public void t1() throws Exception {
        assertThat(new DevFunc().solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})).isEqualTo(new int[]{2, 1});
    }

    @Test
    @DisplayName("progresses = {95, 90, 99, 99, 80, 99}, speeds = {1, 1, 1, 1, 1, 1}, result = {1, 3, 2}")
    public void t2() throws Exception {
        assertThat(new DevFunc().solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})).isEqualTo(new int[]{1, 3, 2});
    }

    @Test
    @DisplayName("progresses = {96,94}, speeds = {3,3}, result = {2}")
    public void t3() throws Exception {
        assertThat(new DevFunc().solution(new int[]{96,94}, new int[]{3,3})).isEqualTo(new int[]{2});
    }
}