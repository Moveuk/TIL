package com.algorithm_proj.programmers.level1;

public class ReverseToMakeArray {
    // 자연수 뒤집어 배열로 만들기 - https://school.programmers.co.kr/learn/courses/30/lessons/12932
    // 자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.
    public int[] solution(long n) {
        int[] answer;

        long n1 = n;
        int index = 0;
        while (n1 != 0) {
            n1 /= 10l;
            index++;
        }

        answer = new int[index];
        for (int i = 0; i < index; i++) {
            answer[i] = (int) (n % 10);
            n /= 10;
        }
        return answer;
    }
}
