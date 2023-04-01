package com.algorithm_proj.programmers.level2;

public class ExpNumber {
    //숫자의 표현 - https://school.programmers.co.kr/learn/courses/30/lessons/12924
    //n을 연속하는 자연수로 표현하는 가지수를 표현하는 함수

    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n/2; i++) {
            int tmp = 0;
            int j = i;
            do {
                tmp += j++;
                if (tmp == n) {
                    answer++;
                }
            } while (tmp < n);
        }
        answer++; //자기 자신
        return answer;
    }
}
