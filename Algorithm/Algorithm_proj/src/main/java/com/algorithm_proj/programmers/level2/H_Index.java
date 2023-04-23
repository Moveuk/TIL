package com.algorithm_proj.programmers.level2;

import java.util.Arrays;

public class H_Index {
    //H-Index - https://school.programmers.co.kr/learn/courses/30/lessons/42747

    public int solution(int[] citations) {
        int answer = 0;
        int[] sortedCitations = Arrays.stream(citations).map(x -> -x).sorted().map(x -> -x).toArray();

        for (int i = 0; i < citations.length; i++) {
            int count = 0;
            for (int citation: sortedCitations) {
                if (i <= citation) {
                    count++;
                }
            }
            if (answer <= i && i <= count && citations.length - count <= i) {
                answer = i;
            }
        }

        return answer;
    }
}
