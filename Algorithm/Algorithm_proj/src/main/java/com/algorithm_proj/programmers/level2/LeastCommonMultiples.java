package com.algorithm_proj.programmers.level2;

public class LeastCommonMultiples {
    //n개의 최소공배수 - https://school.programmers.co.kr/learn/courses/30/lessons/12953
    //유클리드 호제법
    //GCD = 최대공약수
    //LCM = 최소공배수
    //두 수 (a, b)의 최소 공배수는 어떻게 구하는가?
    //a x b = GCD * LCM

    public int solution(int[] arr) {
        int answer = 1;

        for (int i : arr) {
            int max = Integer.max(answer, i);
            int min = Integer.min(answer, i);

            int gcd = 1;
            if (max % min == 0) {
                gcd = min;
            } else {
                int b = min;
                int c = max % min;
                while (true) {
                    if (b % c == 0) {
                        gcd = c;
                        break;
                    } else {
                        int tmp = c;
                        c = b % c;
                        b = tmp;
                    }
                }
            }
            answer = max * min / gcd;
        }

        return answer;
    }

}
