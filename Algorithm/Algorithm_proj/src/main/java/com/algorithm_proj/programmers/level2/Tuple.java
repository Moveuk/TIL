package com.algorithm_proj.programmers.level2;

import java.util.*;

public class Tuple {
    //튜플(2019 카카오 개발자 겨울 인턴십) - https://school.programmers.co.kr/learn/courses/30/lessons/64065

    public int[] solution(String s) {
        int[] answer = {};
        StringBuilder tmp = new StringBuilder();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c != '{' && c != '}' && c != ',') {
                tmp.append(c);
            } else {
                if (tmp.length() != 0) {
                    map.put(Integer.valueOf(tmp.toString()), map.getOrDefault(Integer.valueOf(tmp.toString()), 0) + 1);
                    tmp = new StringBuilder();
                }
            }
        }

        answer = map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).mapToInt(Map.Entry::getKey).toArray();

        return answer;
    }
}
