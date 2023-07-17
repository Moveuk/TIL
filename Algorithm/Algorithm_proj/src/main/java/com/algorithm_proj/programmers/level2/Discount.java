package com.algorithm_proj.programmers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class Discount {
    //할인행사 - https://school.programmers.co.kr/learn/courses/30/lessons/131127

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int countOfItem = Arrays.stream(number).sum();

        HashMap<String, Integer> hashMap = new HashMap<>();
        HashMap<String, Integer> discountMap = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            hashMap.put(want[i], number[i]);
        }

        for (int i = 0; i < discount.length - countOfItem + 1; i++) {
            for (int j = i; j < i + countOfItem; j++) {
                discountMap.put(discount[j], discountMap.getOrDefault(discount[j], 0) + 1);
            }
            //비교
            boolean flag = hashMap.keySet().stream().allMatch(y -> Objects.equals(hashMap.get(y), discountMap.get(y)));
            if (flag) {
                answer += 1;
            }
            discountMap.clear();
        }

        return answer;
    }
}
