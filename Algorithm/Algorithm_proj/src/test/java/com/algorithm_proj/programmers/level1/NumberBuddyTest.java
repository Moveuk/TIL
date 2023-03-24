package com.algorithm_proj.programmers.level1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NumberBuddyTest {

    @Test
    @DisplayName("X=100, Y=2345일 때 결과는 -1이다.")
    void t1() {
        assertThat(new NumberBuddy().solution("100", "2345")).isEqualTo("-1");
    }

    @Test
    @DisplayName("X=100, Y=203045일 때 결과는 0이다.")
    void t2() {
        assertThat(new NumberBuddy().solution("100", "203045")).isEqualTo("0");
    }

    @Test
    @DisplayName("X=100, Y=123450일 때 결과는 0이다.")
    void t3() {
        assertThat(new NumberBuddy().solution("100", "123450")).isEqualTo("10");
    }

    @Test
    @DisplayName("X=12321, Y=42531일 때 결과는 0이다.")
    void t4() {
        assertThat(new NumberBuddy().solution("12321", "42531")).isEqualTo("321");
    }

    @Test
    @DisplayName("X=5525, Y=1255일 때 결과는 0이다.")
    void t5() {
        assertThat(new NumberBuddy().solution("5525", "1255")).isEqualTo("552");
    }

    @Test
    @DisplayName("X=2563890752389, Y=2131278923128일 때 결과는 0이다.")
    void t6() {
        assertThat(new NumberBuddy().solution("2563890752389", "2131278923128")).isEqualTo("552");
    }

    @Test
    @DisplayName("X=25638907523854354392132432343253513, Y=213127543524324234234328923128일 때 결과는 0이다.")
    void t7() {
        assertThat(new NumberBuddy().solution("25638907523854354392132432343253513", "213127543524324234234328923128")).isEqualTo("552");
    }

}