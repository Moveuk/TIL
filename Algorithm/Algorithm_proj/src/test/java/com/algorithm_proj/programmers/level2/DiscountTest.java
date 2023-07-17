package com.algorithm_proj.programmers.level2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class DiscountTest {

    @Test
    @DisplayName("want = {\"banana\", \"apple\", \"rice\", \"pork\", \"pot\"}, number = {3, 2, 2, 2, 1}, discount = {1, 30, 5}, result = 3")
    public void t1() throws Exception {
        assertThat(new Discount().solution(new String[]{"banana", "apple", "rice", "pork", "pot"}, new int[]{3, 2, 2, 2, 1}, new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"})).isEqualTo(3);
    }

    @Test
    @DisplayName("want = {\"apple\"}, number = {10}, discount = {\"banana\", \"banana\", \"banana\", \"banana\", \"banana\", \"banana\", \"banana\", \"banana\", \"banana\", \"banana\"}, result = 0")
    public void t2() throws Exception {
        assertThat(new Discount().solution(new String[]{"apple"}, new int[]{10}, new String[]{"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"})).isEqualTo(0);
    }
}