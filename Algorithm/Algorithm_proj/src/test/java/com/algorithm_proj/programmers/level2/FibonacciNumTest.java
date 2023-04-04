package com.algorithm_proj.programmers.level2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class FibonacciNumTest {

    @Test
    @DisplayName("time check")
    public void timeCheck() throws Exception {
        FibonacciNum fibonacciNum = new FibonacciNum();
        int n = 37000;

        //방법 1 - 캐시없이
        long before = System.currentTimeMillis();
        if (n < 37) { //시간초과
            fibonacciNum.getFibonacciNum(n);
            System.out.println("getFibonacciNum() time = " + (System.currentTimeMillis() - before) + " ms");
        }

        //방법 2 - 캐시
        before = System.currentTimeMillis();
        if (n < 35000) { //36000~ StackOverflow
            fibonacciNum.getFibonacciNumWithCache(n);
            System.out.println("getFibonacciNumWithCache() time = " + (System.currentTimeMillis() - before) + " ms");
        }

        //방법 3 - 공식
        before = System.currentTimeMillis();
        double fibonacciNumByFormula = fibonacciNum.getFibonacciNumByFormula(n);
        System.out.println("fibonacciNumByFormula = " + fibonacciNumByFormula);
        System.out.println("timeC = " + (System.currentTimeMillis() - before));
    }

    @Test
    @DisplayName("n=3 return 2")
    public void t1() throws Exception {
        assertThat(new FibonacciNum().solution(3)).isEqualTo(2);
    }

    @Test
    @DisplayName("n=5 return 5")
    public void t2() throws Exception {
        assertThat(new FibonacciNum().solution(5)).isEqualTo(5);
    }
}