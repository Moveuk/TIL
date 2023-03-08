package com.algorithm_proj.programmers.level1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class IDontLikeSameNumber {
    // 같은 숫자는 싫어 - https://school.programmers.co.kr/learn/courses/30/lessons/12906
    // 배열 arr가 주어집니다. 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다.
    // 이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다.
    // 단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다. 예를 들면,
    // arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 return 합니다.
    // arr = [4, 4, 4, 3, 3] 이면 [4, 3] 을 return 합니다.
    // 배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return 하는 solution 함수를 완성해 주세요.

    public int[] solution(int []arr) {
        int[] answer = {};

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> queue_ans = new LinkedList<>();


        AtomicInteger tmp = new AtomicInteger(-1);
        Arrays.stream(arr).forEach((x) -> {
            if (x != tmp.get()) {
                queue.add(x);
                tmp.set(x);
            }
        });

        answer = new int[queue.size()];

        int cycle = queue.size();
        for (int i = 0; i < cycle ; i++) {
            int z = queue.peek();
            answer[i] = z; // 큐에서 빼서 넣음
            queue.remove();
        }

        return answer;
    }
}
