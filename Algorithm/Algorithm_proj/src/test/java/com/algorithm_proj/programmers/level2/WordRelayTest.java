package com.algorithm_proj.programmers.level2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class WordRelayTest {

    @Test
    @DisplayName("n = 3, words = [\"tank\", \"kick\", \"know\", \"wheel\", \"land\", \"dream\", \"mother\", \"robot\", \"tank\"]" +
            " result = [3, 3]")
    public void t1() throws Exception {
        assertThat(new WordRelay().solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})).isEqualTo(new int[]{3, 3});
    }

    @Test
    @DisplayName("n = 5, words = [\"hello\", \"observe\", \"effect\", \"take\", \"either\", \"recognize\", \"encourage\", \"ensure\", \"establish\", \"hang\", \"gather\", \"refer\", \"reference\", \"estimate\", \"executive\"]" +
            " result = [0, 0]")
    public void t2() throws Exception {
        assertThat(new WordRelay().solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"})).isEqualTo(new int[]{0, 0});
    }

    @Test
    @DisplayName("n = 2, words = [\"hello\", \"one\", \"even\", \"never\", \"now\", \"world\", \"draw\"]" +
            " result = [1, 3]")
    public void t3() throws Exception {
        assertThat(new WordRelay().solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"})).isEqualTo(new int[]{1, 3});
    }

}