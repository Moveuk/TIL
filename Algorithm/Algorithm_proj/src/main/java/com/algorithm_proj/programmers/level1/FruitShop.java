package com.algorithm_proj.programmers.level1;

import java.util.Arrays;

public class FruitShop {
    // 과일 장수 - https://school.programmers.co.kr/learn/courses/30/lessons/135808
    // 한 상자에 사과를 m개씩 담아 포장합니다.
    // 상자에 담긴 사과 중 가장 낮은 점수가 p (1 ≤ p ≤ k)점인 경우, 사과 한 상자의 가격은 p * m 입니다.

    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int[] scores = Arrays.stream(score)
                .map(i -> -i)
                .sorted()
                .map(i -> -i)
                .toArray();
        int index = 0;
        while (index < scores.length && index + m <= scores.length) {
            answer += scores[index + m - 1] * m;

            index += m;
        }
        return answer;
    }

}
