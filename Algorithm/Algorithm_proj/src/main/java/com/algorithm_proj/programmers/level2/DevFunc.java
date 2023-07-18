package com.algorithm_proj.programmers.level2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class DevFunc {
    //기능개발 - https://school.programmers.co.kr/learn/courses/30/lessons/42586

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();
        int numOfFunc;

        for (int i = 0; i < progresses.length; i++) {
            int tmp = (1000 - progresses[i] * 10) / speeds[i];
            if (tmp % 10 != 0) {
                System.out.println("tmp = " + tmp);
                tmp = tmp / 10 + 1;
            } else {
                tmp /= 10;
            }
            queue.add(tmp);
        }

        boolean flag = true;
        while (flag) {
            numOfFunc = 1;
            int tmp = queue.removeFirst();
            if (queue.isEmpty()) {
                list.add(numOfFunc);
                break;
            }
            while (queue.getFirst() <= tmp) {
                numOfFunc++;
                queue.removeFirst();
                if (queue.isEmpty()) {
                    flag = false;
                    break;
                }
            }
            list.add(numOfFunc);
        }

        answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
