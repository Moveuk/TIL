package com.algorithm_proj.programmers.level2;

public class BinaryConversion {
    //이진 변환 반복하기 - https://school.programmers.co.kr/learn/courses/30/lessons/70129
    //x = "0111010"이라면, x에 이진 변환을 가하면 x = "0111010" -> "1111" -> "100" 이 됩니다.
    //1이 될 때까지 반복

    public int[] solution(String s) {
        int[] answer = {0, 0};
        while (!s.equals("1")) {
            while (s.contains("0")) {
                s = s.replaceFirst("0", "");
                answer[1]++;
            }
            s = Integer.toBinaryString(s.length());
            answer[0]++;
        }
        return answer;
    }
}
