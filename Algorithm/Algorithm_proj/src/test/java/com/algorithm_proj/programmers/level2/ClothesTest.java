package com.algorithm_proj.programmers.level2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ClothesTest {

    @Test
    @DisplayName("sample 1 test")
    public void t1() throws Exception {
        assertThat(new Clothes().solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}})).isEqualTo(5);
    }

    @Test
    @DisplayName("sample 2 test")
    public void t2() throws Exception {
        assertThat(new Clothes().solution(new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}})).isEqualTo(3);
    }
}