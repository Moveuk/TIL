package com.algorithm_proj.programmers.level1;

public class SumOfDivisor {
    // 약수의 합 - https://school.programmers.co.kr/learn/courses/30/lessons/12928
    // 정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.

    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i < n + 1; i++) {
            answer += n % i == 0 ? i : 0;
        }

        return answer;
    }
}
