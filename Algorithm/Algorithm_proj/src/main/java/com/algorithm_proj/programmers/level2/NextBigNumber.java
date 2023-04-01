package com.algorithm_proj.programmers.level2;

public class NextBigNumber {
    //다음 큰 숫자 - https://school.programmers.co.kr/learn/courses/30/lessons/12911

    public int solution(int n) {
        int answer = 0;
        int bitCount = Integer.bitCount(n);

        while (true) {
            n++;
            if (Integer.bitCount(n) == bitCount) {
                return n;
            }
        }
    }
}
