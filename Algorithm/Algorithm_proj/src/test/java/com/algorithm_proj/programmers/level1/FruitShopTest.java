package com.algorithm_proj.programmers.level1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class FruitShopTest {

    @Test
    @DisplayName("k=3, m=4, score[1,2,3,1,2,3,1]일 때 결과는 8이다.")
    void t1() {
        assertThat(new FruitShop().solution(3,4,new int[]{1,2,3,1,2,3,1})).isEqualTo(8);
    }

    @Test
    @DisplayName("k=4, m=3, score[4,1,2,2,4,4,4,4,1,2,4,2]일 때 결과는 8이다.")
    void t2() {
        assertThat(new FruitShop().solution(4,3,new int[]{4,1,2,2,4,4,4,4,1,2,4,2})).isEqualTo(33);
    }
}