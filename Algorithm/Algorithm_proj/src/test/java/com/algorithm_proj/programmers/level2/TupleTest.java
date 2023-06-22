package com.algorithm_proj.programmers.level2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class TupleTest {

    @Test
    @DisplayName("s = \"{{2},{2,1},{2,1,3},{2,1,3,4}}\", result = [2, 1, 3, 4]")
    public void t1() throws Exception {
        assertThat(new Tuple().solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")).isEqualTo(new int[]{2, 1, 3, 4});
    }

    @Test
    @DisplayName("s = \"{{1,2,3},{2,1},{1,2,4,3},{2}}\", result = [2, 1, 3, 4]")
    public void t2() throws Exception {
        assertThat(new Tuple().solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")).isEqualTo(new int[]{2, 1, 3, 4});
    }

    @Test
    @DisplayName("s = \"{{20,111},{111}}\", result = [111, 20]")
    public void t3() throws Exception {
        assertThat(new Tuple().solution("{{20,111},{111}}")).isEqualTo(new int[]{111, 20});
    }

    @Test
    @DisplayName("s = \"{{123}}\", result = [123]")
    public void t4() throws Exception {
        assertThat(new Tuple().solution("{{123}}")).isEqualTo(new int[]{123});
    }

    @Test
    @DisplayName("s = \"{{4,2,3},{3},{2,3,4,1},{2,3}}\", result = [3, 2, 4, 1]")
    public void t5() throws Exception {
        assertThat(new Tuple().solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")).isEqualTo(new int[]{3, 2, 4, 1});
    }
}