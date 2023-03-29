package com.algorithm_proj.programmers.level2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CorrectBracketTest {

    @Test
    @DisplayName("()() -> true")
    public void t1() throws Exception {
        assertThat(new CorrectBracket().solution("()()")).isEqualTo(true);
    }

    @Test
    @DisplayName("(())() -> true")
    public void t2() throws Exception {
        assertThat(new CorrectBracket().solution("(())()")).isEqualTo(true);
    }

    @Test
    @DisplayName(")()( -> false")
    public void t3() throws Exception {
        assertThat(new CorrectBracket().solution(")()(")).isEqualTo(false);
    }

    @Test
    @DisplayName("(()( -> false")
    public void t4() throws Exception {
        assertThat(new CorrectBracket().solution("(()(")).isEqualTo(false);
    }

}