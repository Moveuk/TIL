package com.algorithm_proj.programmers.level2;

public class ExpectedSchedule {
    // 예상 대진표 - https://school.programmers.co.kr/learn/courses/30/lessons/12985
    //

    public int solution(int n, int a, int b) {
        int answer = (int) (Math.log(n) / Math.log(2));

        int[] arr = new int[]{Math.min(a, b), Math.max(a, b)};

        int p1 = 0;
        int p2 = n/2;
        int p3 = n;

        while (true) {
            if (((p1 < arr[0] && arr[0] <= p2) && (p2 < arr[1] && arr[1] <= p3))) {
                break;
            } else if (((p1 < arr[0] && arr[0] <= p2))) {
                p3 = p2;
            } else if (((p2 < arr[0] && arr[0] <= p3))) {
                p1 = p2;
            }
            p2 = (p1 + p3) / 2;
            answer--;
        }
        return answer;
    }

    //각 노드가 확장된다는 기념으로 본것.
    public int solution2 (int n, int a, int b) {
        int round = 0;
        while(a != b) {
            a = a/2 + a%2;
            b = b/2 + b%2;
            round++;
        }
        return round;
    }

}
