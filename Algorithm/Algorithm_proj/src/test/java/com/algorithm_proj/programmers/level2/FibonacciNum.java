package com.algorithm_proj.programmers.level2;

public class FibonacciNum {
    //피보나치 수 - https://school.programmers.co.kr/learn/courses/30/lessons/12945
    //피보나치 수를 n으로 나눈 나머지를 리턴하는 함수
    long[] cache;

    public int solution(int n) {
        return (int) getFibonacciNumNoRecursion(n) % 1234567;
    }

    public long getFibonacciNum(int n) {
        if (n <= 0) {
            return 0L;
        } else if (n == 1 || n == 2) {
            return 1L;
        }
        return getFibonacciNum(n - 2) + getFibonacciNum(n - 1);
    }

    public long getFibonacciNumWithCache(int n) {
        if (cache == null) {
            cache = new long[n+1];
            cache[0] = 0L;
            cache[1] = 1L;
            cache[2] = 1L;
        }
        if (n <= 0) {
            return cache[0];
        } else if (n == 1) {
            return cache[1];
        }
        cache[n] = cache[n - 2] + cache[n - 1];
        if (cache[n] != 0) {
            return cache[n];
        }
        return getFibonacciNumWithCache(n - 2) + getFibonacciNumWithCache(n - 1);
    }

    public double getFibonacciNumByFormula(int n) {
        double sqrt5 = Math.sqrt(5);
        return (1d/sqrt5) * (Math.pow((1d+sqrt5)/2d, n) - Math.pow((1d-sqrt5)/2d, n));
    }

    public long getFibonacciNumNoRecursion(int n) {
        if (cache == null) {
            cache = new long[n + 1];
            cache[0] = 0L;
            cache[1] = 1L;
        }
        for (int i = 0; i <= n; i++) {
            if (i >= 2) {
                long sum = cache[i - 2] + cache[i - 1];
                cache[i] = sum % 1234567L;
            }
        }
        return cache[n];
    }
}
