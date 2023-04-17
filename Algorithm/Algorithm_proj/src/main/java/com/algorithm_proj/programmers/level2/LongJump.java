package com.algorithm_proj.programmers.level2;

public class LongJump {
    //멀리뛰기 - https://school.programmers.co.kr/learn/courses/30/lessons/12914

    public static long[] cache;

    public long solution(int n) {
        if (cache == null) {
            cache = new long[n + 1];
            cache[0] = 1L;
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
