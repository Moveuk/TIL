package com.algorithm_proj.programmers.level2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StringJadenCaseTest {

    @Test
    @DisplayName("s=\"3people unFollowed me\", return \"3people Unfollowed Me\"")
    void t1() {
        assertThat(new StringJadenCase().solution("3people unFollowed me")).isEqualTo("3people Unfollowed Me");
    }

    @Test
    @DisplayName("s=\"for the last week\", return \"For The Last Week\"")
    void t2() {
        assertThat(new StringJadenCase().solution("for the last week")).isEqualTo("For The Last Week");
    }

    @Test
    @DisplayName("공백이 2개이상 : s=\"the  last  week\", return \"The  Last  Week\"")
    void t3() {
        assertThat(new StringJadenCase().solution("the  last  week")).isEqualTo("The  Last  Week");
    }

    @Test
    @DisplayName("뒷 공백 경우 : s=\"the  last  week \", return \"The  Last  Week \"")
    void t4() {
        assertThat(new StringJadenCase().solution("the  last  week ")).isEqualTo("The  Last  Week ");
    }

}