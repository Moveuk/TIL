package com.algorithm_proj.programmers.level2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CacheTest {

    @Test
    @DisplayName("cacheSize = 3, cities = [\"Jeju\", \"Pangyo\", \"Seoul\", \"NewYork\", \"LA\", \"Jeju\", \"Pangyo\", \"Seoul\", \"NewYork\", \"LA\"], result 50")
    public void t1() throws Exception {
        assertThat(new Cache().solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"})).isEqualTo(50);
    }

    @Test
    @DisplayName("cacheSize = 3, cities = [\"Jeju\", \"Pangyo\", \"Seoul\", \"Jeju\", \"Pangyo\", \"Seoul\", \"Jeju\", \"Pangyo\", \"Seoul\"], result 21")
    public void t2() throws Exception {
        assertThat(new Cache().solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"})).isEqualTo(21);
    }

    @Test
    @DisplayName("cacheSize = 2, cities = [\"Jeju\", \"Pangyo\", \"Seoul\", \"NewYork\", \"LA\", \"SanFrancisco\", \"Seoul\", \"Rome\", \"Paris\", \"Jeju\", \"NewYork\", \"Rome\"], result 60")
    public void t3() throws Exception {
        assertThat(new Cache().solution(2, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"})).isEqualTo(60);
    }

    @Test
    @DisplayName("cacheSize = 5, cities = [\"Jeju\", \"Pangyo\", \"Seoul\", \"NewYork\", \"LA\", \"SanFrancisco\", \"Seoul\", \"Rome\", \"Paris\", \"Jeju\", \"NewYork\", \"Rome\"], result 52")
    public void t4() throws Exception {
        assertThat(new Cache().solution(5, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"})).isEqualTo(52);
    }

    @Test
    @DisplayName("cacheSize = 2, cities = [\"Jeju\", \"Pangyo\", \"NewYork\", \"newyork\"], result 16")
    public void t5() throws Exception {
        assertThat(new Cache().solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"})).isEqualTo(16);
    }

    @Test
    @DisplayName("cacheSize = 30, cities = [\"Jeju\", \"Pangyo\", \"Seoul\", \"NewYork\", \"LA\", \"Jeju\", \"Pangyo\", \"Seoul\", \"NewYork\", \"LA\"], result 25")
    public void t6() throws Exception {
        assertThat(new Cache().solution(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"})).isEqualTo(25);
    }
}