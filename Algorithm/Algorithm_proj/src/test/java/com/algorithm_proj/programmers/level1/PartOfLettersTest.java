package com.algorithm_proj.programmers.level1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PartOfLettersTest {

    @Test
    @DisplayName("t가 3141592이고 p가 271일 때 결과값은 2이다.")
    void t1() {
        assertThat(new PartOfLetters().solution("3141592", "271")).isEqualTo(2);
    }

    @Test
    @DisplayName("t가 500220839878이고 p가 7일 때 결과값은 8이다.")
    void t2() {
        assertThat(new PartOfLetters().solution("500220839878", "7")).isEqualTo(8);
    }

    @Test
    @DisplayName("t가 10203이고 p가 15일 때 결과값은 3이다.")
    void t3() {
        assertThat(new PartOfLetters().solution("10203", "15")).isEqualTo(3);
    }

}