package com.algorithm_proj.programmers.level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HallOfFame {
    // 명예의 전당 - https://school.programmers.co.kr/learn/courses/30/lessons/138477
    //

    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> kthRank = new ArrayList<>();

        for (int i = 0; i < score.length; i++) {
            kthRank.add(score[i]);
            if (kthRank.size() < k) {
                answer[i] = kthRank.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList()).get(i);
            } else {
                answer[i] = kthRank.stream().sorted(Collections.reverseOrder()).limit(k).collect(Collectors.toList()).get(k - 1);
            }
        }
        return answer;
    }
}
