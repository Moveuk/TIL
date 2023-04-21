package com.algorithm_proj.programmers.level2;

import java.util.*;

public class ChooseTang {
    //귤 고르기 - https://school.programmers.co.kr/learn/courses/30/lessons/138476

    public int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int sizeOfTang : tangerine) {
            map.put(sizeOfTang, map.getOrDefault(sizeOfTang, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> mapList = new LinkedList<>(map.entrySet());

        mapList.sort((i1, i2) -> map.get(i2.getKey()) - map.get(i1.getKey()));

        for(Map.Entry<Integer, Integer> entry : mapList){
            answer++;
            k -= entry.getValue();
            if (k <= 0) {
                break;
            }
        }

        return answer;
    }
}
