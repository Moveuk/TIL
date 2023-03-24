package com.algorithm_proj.programmers.level1;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberBuddy {
    // 숫자 짝궁 - https://school.programmers.co.kr/learn/courses/30/lessons/131128
    // 두 정수 X, Y의 공통인자를 사용하여 만들 수 있는 가장 큰 수 구하기.

    // 시간초과
    public String solution(String X, String Y) {
        String answer = "";
        String buddies = "";

        for (int i = 0; i < X.length(); i++) {
            for (int j = 0; j < Y.length(); j++) {
                if (X.charAt(i) == Y.charAt(j)) {
                    buddies += X.charAt(i);
                    Y = Y.replaceFirst(String.valueOf(X.charAt(i)), "a");
                    break;
                }
            }
        }

        if (buddies.equals("")) {
            answer = "-1";
        } else if (buddies.matches("^0*$")) {
            answer = "0";
        } else {
            String finalBuddies = buddies;
            answer = IntStream.range(0, buddies.length())
                    .mapToObj(i -> String.valueOf(finalBuddies.charAt(i)))
                    .sorted(Collections.reverseOrder())
                    .collect(Collectors.joining());
        }
        System.out.println("answer = " + answer);
        return answer;
    }

    // 테스트 11, 12, 13, 14, 15 - 시간초과로 인한 문제 풀이
    public String solution2(String X, String Y) {
        String answer = "";
        String buddies = "";

        return answer;
    }

}
