package com.algorithm_proj.programmers.level1.lessons172928

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `park={"SOO","OOO","OOO"}, routes={"E 2","S 2","W 1"}일 때 result={2,1}이다`() {
        //given
        val park = arrayOf("SOO","OOO","OOO")
        val routes = arrayOf("E 2","S 2","W 1")

        //when
        val result = solution.solution(park, routes)

        //then
        assertThat(result).isEqualTo(arrayOf(2,1))
    }

    @Test
    fun `park={"SOO","OXX","OOO"}, routes={"E 2","S 2","W 1"}일 때 result={0,1}이다`() {
        //given
        val park = arrayOf("SOO","OXX","OOO")
        val routes = arrayOf("E 2","S 2","W 1")

        //when
        val result = solution.solution(park, routes)

        //then
        assertThat(result).isEqualTo(arrayOf(0,1))
    }

    @Test
    fun `park={"OSO","OOO","OXO","OOO"}, routes={"E 2","S 2","W 1"}일 때 result={0,0}이다`() {
        //given
        val park = arrayOf("OSO","OOO","OXO","OOO")
        val routes = arrayOf("E 2","S 2","W 1")

        //when
        val result = solution.solution(park, routes)

        //then
        assertThat(result).isEqualTo(arrayOf(0,0))
    }

    @Test
    fun `park={"OOX", "OXO", "OOS"}, routes={"E 2", "E 3", "N 1"}일 때 result={1, 2}이다`() {
        //given
        val park = arrayOf("OOX", "OXO", "OOS")
        val routes = arrayOf("E 2", "E 3", "N 1")

        //when
        val result = solution.solution(park, routes)

        //then
        assertThat(result).isEqualTo(arrayOf(1, 2))
    }

    @Test
    fun `park={"OOS", "OOO", "OOO"}, routes={"W 1"}일 때 result={0, 1}이다`() {
        //given
        val park = arrayOf("OOS", "OOO", "OOO")
        val routes = arrayOf("W 1")

        //when
        val result = solution.solution(park, routes)

        //then
        assertThat(result).isEqualTo(arrayOf(0, 1))
    }

    @Test
    fun `park={"OXXO", "XSXO", "XXXX"}, routes={"E 1", "S 1"}일 때 result={1, 1}이다`() {
        //given
        val park = arrayOf("OXXO", "XSXO", "XXXX")
        val routes = arrayOf("E 1", "S 1")

        //when
        val result = solution.solution(park, routes)

        //then
        assertThat(result).isEqualTo(arrayOf(1, 1))
    }

    @Test
    fun `park={"OOO", "OSO", "OOO", "OOO"}, routes={"N 2", "S 2"}일 때 result={3, 1}이다`() {
        //given
        val park = arrayOf("OOO", "OSO", "OOO", "OOO")
        val routes = arrayOf("N 2", "S 2")

        //when
        val result = solution.solution(park, routes)

        //then
        assertThat(result).isEqualTo(arrayOf(3, 1))
    }

    @Test
    fun `park={"SOOOO","OOOOO","OOOOO"}, routes={"E 3","S 2","W 3"}일 때 result={2, 0}이다`() {
        //given
        val park = arrayOf("SOOOO","OOOOO","OOOOO")
        val routes = arrayOf("E 3","S 2","W 3")

        //when
        val result = solution.solution(park, routes)

        //then
        assertThat(result).isEqualTo(arrayOf(2, 0))
    }
}