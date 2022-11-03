package com.algorithm_proj.programmers.level1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortingLettesInMyWay {
    // 문자열 내 마음대로 정렬하기 - https://school.programmers.co.kr/learn/courses/30/lessons/12915
    // 문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때, 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다.
    // 예를 들어 strings가 ["sun", "bed", "car"]이고 n이 1이면 각 단어의 인덱스 1의 문자 "u", "e", "a"로 strings를 정렬합니다.

    public String[] solution(String[] strings, int n) {

        String[] answer = new String[strings.length];

        // n 값이 단어 중 제일 짧은 글자수 이하로 나오는지 모름.

        // 커스텀 비교인자
        Comparator<String> comparator = (s1, s2) -> {
            if (s1.charAt(n) > s2.charAt(n)) { // n 번째 문자에 대해서는 오름차순
                return 1;
            } else if (s1.charAt(n) == s2.charAt(n)) { // n번째 문자가 같으면
                return s1.compareTo(s2);
            }
            return -1;
        };

        List<String> list = Arrays.asList(strings);
        list.sort(comparator);
        for (int i = 0; i < strings.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
