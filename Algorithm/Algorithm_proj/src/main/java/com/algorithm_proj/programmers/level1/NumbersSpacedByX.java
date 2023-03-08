package com.algorithm_proj.programmers.level1;

public class NumbersSpacedByX {
    // x만큼 간격이 있는 n개의 숫자 - https://school.programmers.co.kr/learn/courses/30/lessons/12954
    // 함수 solution은 정수 x와 자연수 n을 입력 받아, x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴해야 합니다.
    // 다음 제한 조건을 보고, 조건을 만족하는 함수, solution을 완성해주세요.

    public long[] solution(int x, int n) {
        long[] answer = new long[n];

        for (int i = 0; i < n; i++) {
            answer[i] = (long)x*(long)(i+1);
        }

        return answer;
        // int형은 data가 한계가 있음. –2,147,483,648 ~ 2,147,483,647
        // int 계산은 x 최댓값 x n 최댓값을 넘어버림
        // 10000000 X 1000
        // 10000000000
        //  2147483647
        // 직관적이지 못함
        // -> 다음 행을 이전행에서 더하면됨
        // for (int i = 1; i < n; i++) {
        //    answer[i] = answer[i - 1] + x;
        //}
        // 더 좋은 한줄 풀이
        // return Array.from(Array(n), (_, index) => x * (index + 1));
        // from 메소드 사용
    }
}
