package com.algorithm_proj.programmers.level2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Clothes {
    //의상(해시) - https://school.programmers.co.kr/learn/courses/30/lessons/42578

    public int solution(String[][] clothes) {
        AtomicInteger answer = new AtomicInteger(1);
        Map<String, Integer> counts = new HashMap<>();

        //종류 카테고리화
        for (String[] set : clothes) {
            counts.put(set[1], counts.getOrDefault(set[1], 0) + 1);
        }

        Set<String> kinds = counts.keySet();
        kinds.forEach(x -> answer.updateAndGet(v -> v * (counts.get(x) + 1)));

        return answer.get() - 1;
    }
}
