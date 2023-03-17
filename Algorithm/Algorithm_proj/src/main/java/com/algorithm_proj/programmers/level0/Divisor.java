package com.algorithm_proj.programmers.level0;

import java.util.ArrayList;
import java.util.List;

public class Divisor {
    // 약수 구하기 - https://school.programmers.co.kr/learn/courses/30/lessons/120897
    // 정수 n이 매개변수로 주어질 때, n의 약수를 오름차순으로 담은 배열을 return하도록 solution 함수를 완성해주세요.

    public int[] solution(int n) {
        int[] answer;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < n+1; i++) {
            if (n % i == 0) {
                list.add(i);
            }
        }
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
