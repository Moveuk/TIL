package com.algorithm_proj.programmers.level2;

import java.util.HashSet;
import java.util.Set;

public class WordRelay {
    //영어 끝말잇기 - https://school.programmers.co.kr/learn/courses/30/lessons/12981


    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int[] nCount = new int[n];
        int index = 0;

        Set<String> wordSet = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            nCount[index++]++;
            if (wordSet.contains(words[i]) ||
                    (i > 0 && words[i].charAt(0) != words[i-1].charAt(words[i-1].length()-1))) {
                answer[0] = index;
                answer[1] = nCount[index - 1];
                return answer;
            } else {
                wordSet.add(words[i]);
            }

            if (index == n) {
                index = 0;
            }
        }

        return answer;
    }
}
