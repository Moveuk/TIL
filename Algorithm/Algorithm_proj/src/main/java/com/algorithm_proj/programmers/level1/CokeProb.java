package com.algorithm_proj.programmers.level1;

public class CokeProb {
    // 콜라 문제 - https://school.programmers.co.kr/learn/courses/30/lessons/132267
    // 빈 콜라 병 a병을 가져다 주면 새 콜라 b병을 빈 병 n개를 가져다 주면 총 몇 병의 콜라를 받는지?

    // 제한 조건
    // 1. 1 ≤ b < a ≤ n ≤ 1,000,000
    // 2. 정답은 항상 int 범위를 넘지 않게 주어집니다.

    public int solution(int a, int b, int n) {
        int answer = 0;

        while (true) {
            answer += n / a * b;
            n = n - a * (n / a) + n / a * b;
            if (n < a) {
                break;
            }
        }

        return answer;
    }
}
