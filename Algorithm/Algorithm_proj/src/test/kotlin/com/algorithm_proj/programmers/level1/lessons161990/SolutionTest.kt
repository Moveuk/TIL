package com.algorithm_proj.programmers.level1.lessons161990

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `wallpaper가 아래와 같을 때 result={0, 1, 3, 4}이다`() {
        //given
        val wallpaper= arrayOf(".#...", "..#..", "...#.")

        //when
        val result = solution.solution(wallpaper)

        //then
        assertThat(result).isEqualTo(intArrayOf(0, 1, 3, 4))
    }

    @Test
    fun `wallpaper가 아래와 같을 때 result={1, 3, 5, 8}이다`() {
        //given
        val wallpaper= arrayOf("..........", ".....#....", "......##..", "...##.....", "....#.....")

        //when
        val result = solution.solution(wallpaper)

        //then
        assertThat(result).isEqualTo(intArrayOf(1, 3, 5, 8))
    }

    @Test
    fun `wallpaper가 아래와 같을 때 result={0, 0, 7, 9}이다`() {
        //given
        val wallpaper= arrayOf(".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#....")

        //when
        val result = solution.solution(wallpaper)

        //then
        assertThat(result).isEqualTo(intArrayOf(0, 0, 7, 9))
    }

    @Test
    fun `wallpaper가 아래와 같을 때 result={1, 0, 2, 1}이다`() {
        //given
        val wallpaper= arrayOf("..", "#.")

        //when
        val result = solution.solution(wallpaper)

        //then
        assertThat(result).isEqualTo(intArrayOf(1, 0, 2, 1))
    }
}