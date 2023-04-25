package com.algorithm_proj.programmers.level2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MultiplyMatrixTest {

    @Test
    @DisplayName("arr1 = [[1, 4], [3, 2], [4, 1]], arr2 = [[3, 3], [3, 3]], return = [[15, 15], [15, 15], [15, 15]]")
    public void t1() throws Exception {
        assertThat(new MultiplyMatrix().solution(new int[][]{{1, 4}, {3, 2}, {4, 1}}, new int[][]{{3, 3}, {3, 3}})).isEqualTo(new int[][]{{15, 15}, {15, 15}, {15, 15}});
    }

    @Test
    @DisplayName("arr1 = [[2, 3, 2], [4, 2, 4], [3, 1, 4]], arr2 = [[5, 4, 3], [2, 4, 1], [3, 1, 1]], return = [[22, 22, 11], [36, 28, 18], [29, 20, 14]]")
    public void t2() throws Exception {
        assertThat(new MultiplyMatrix().solution(new int[][]{{2, 3, 2}, {4, 2, 4}, {3, 1, 4}}, new int[][]{{5, 4, 3}, {2, 4, 1}, {3, 1, 1}})).isEqualTo(new int[][]{{22, 22, 11}, {36, 28, 18}, {29, 20, 14}});
    }

    @Test
    @DisplayName("arr1 = [[2, 3, 2], [4, 2, 4], [3, 1, 4]], arr2 = [[5, 4], [2, 4], [3, 1]], return = [[22, 22], [36, 28], [29, 20]]")
    public void t3() throws Exception {
        assertThat(new MultiplyMatrix().solution(new int[][]{{2, 3, 2}, {4, 2, 4}, {3, 1, 4}}, new int[][]{{5, 4}, {2, 4}, {3, 1}})).isEqualTo(new int[][]{{22, 22}, {36, 28}, {29, 20}});
    }
}