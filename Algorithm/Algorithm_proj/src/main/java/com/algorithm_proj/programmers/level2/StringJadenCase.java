package com.algorithm_proj.programmers.level2;

public class StringJadenCase {
    //JadenCase 문자열 만들기 - https://school.programmers.co.kr/learn/courses/30/lessons/12951
    //JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다.
    //String s를 JadenCase로 만드는 함수

    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        s += "Z";
        String[] strArr = s.toLowerCase().split(" ");
        System.out.println("strArr.length = " + strArr.length);
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].length() != 0) {
                if (!(strArr[i].charAt(0) >= 65 && 90 >= strArr[i].charAt(0))) {
                    String letter = String.valueOf(strArr[i].charAt(0));
                    strArr[i] = strArr[i].replaceFirst(letter, letter.toUpperCase());
                }
            }
            answer.append(strArr[i]);
            if (i != strArr.length-1) {
                answer.append(" ");
            }
        }

        answer.deleteCharAt(answer.length() - 1);

        return answer.toString();
    }

    //split은 한글자씩 쪼갤수있음.
    public String solution2(String s) {
        String answer = "";
        String[] sp = s.toLowerCase().split("");
        boolean flag = true;

        for(String ss : sp) {
            answer += flag ? ss.toUpperCase() : ss;
            flag = ss.equals(" ") ? true : false;
        }

        return answer;
    }


}
