package com.algorithm_proj.programmers.level2;

public class Country124 {
    //124 나라의 숫자 - https://school.programmers.co.kr/learn/courses/30/lessons/12899

    public String solution(int n) {
        StringBuilder answer = new StringBuilder();

        while (n > 0) {
            int num = n%3;
            if (num == 0) {
                answer.insert(0, "4");
                n = n/3 - 1;
            }
            else {
                answer.insert(0, Integer.toString(num));
                n = n/3;
            }

        }

        return answer.toString();
    }
}
