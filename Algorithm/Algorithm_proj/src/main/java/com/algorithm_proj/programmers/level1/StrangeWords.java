package com.algorithm_proj.programmers.level1;

public class StrangeWords {
    // 이상한 문자 만들기 - https://school.programmers.co.kr/learn/courses/30/lessons/12930
    // 공백(" ") 단위 별로 홀,짝수를 가려 홀수자리는 대문자 짝수자리는 소문자로 만듬.

    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] sArr = s.split(" ");

        for (String value : sArr) {
            String[] split = value.toLowerCase().split("");
            for (int j = 0; j < split.length; j++) {
                if (j % 2 == 0) {
                    answer.append(split[j].toUpperCase());
                } else {
                    answer.append(split[j].toLowerCase());
                }
            }
            if (value.length() > 0) {
                answer.append(" ");
            }
        }

        return answer.toString().trim();
    }

    public static void main(String[] args) {
        StrangeWords sw = new StrangeWords();

        System.out.println(sw.solution("try       world"));
    }
}
