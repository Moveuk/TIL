package com.algorithm_proj.programmers.level2;

import java.util.stream.LongStream;

public class CutNSquare {
    //N^2 배열 자르기 - https://school.programmers.co.kr/learn/courses/30/lessons/87390

    //규칙 - 행은 나누었을때 몫, 열의 값은 나머지를 의미함.
    public int[] solutionWithStream(int n, long left, long right) {
        return LongStream.rangeClosed(left, right).mapToInt(value -> (int) (Math.max(value / n, value % n) + 1)).toArray();
    }

    //구간 단축
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];

        for (long i = left / n - 1; i < right / n + 1; i++) {
            for (long j = 0; j < n; j++) {
                int index = (int) (n * i + j);
                if (left <= n * i + j && n * i + j <= right) {
                    answer[(int) (index - left)] = (int) (i > j ? i + 1 : j + 1);
                }
            }
        }

        return answer;
    }

    //1 ≤ n ≤ 10^7 이므로 커지면 시간초과
    public int[] solution2(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        int[] temp = new int[n * n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[n * i + j] = i > j ? i + 1 : j + 1;
            }
        }

        System.arraycopy(temp, (int) left, answer, 0, (int) (right - left + 1));

        return answer;
    }
}
