package com.algorithm_proj.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lifeboat {
    //구명보트 - https://school.programmers.co.kr/learn/courses/30/lessons/42885
    //사람들의 몸무게와 무게 제한이 주어질 경우 구출에 필요한 최소한의 구명보트 개수를 리턴하도록 작성

    //최소와 최대를 저장해두고 최대 2명 탈 수 있다
    //절반보다 큰 경우는 남은 무게가 최소의 값보다 여유있으면 리밋에 근접한 것을 붙여줌.
    //절반보다 작은 경우는 작은 것들을 조합해서 나올 수 있는 최적의 수를 찾아야함.
    //무조건 몸무게의 합을 제한으로 나눈 정수보다 작음.
    public int solution(int[] people, int limit) {
        //원시적으로 짜기
        int answer = 0;

        people = Arrays.stream(people).sorted().toArray();
        boolean[] check = new boolean[people.length];
        int mark = 0;

        //혼자인 것 처리
        for (int i = people.length - 1; i >= 0; i--) {
            if (limit - people[0] >= people[i]) {
                mark = i;
                break;
            }
            check[i] = true;
            answer++;
        }

        //2개 고르기
        for (int i = mark; i >= 0; i--) {
            if (!check[i]) {
                check[i] = true;
                answer++;
                for (int j = i - 1; j >= 0; j--) {
                    if (!check[j] && limit - people[i] >= people[j]) {
                        check[j] = true;
                        break;
                    }
                }
            }
        }
        return answer;
    }

    public int solution2(int[] people, int limit) {
        int answer = 0;

        List<Integer> peopleList = new ArrayList<>(Arrays.stream(people).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList()));
        int minWeight = peopleList.get(people.length - 1);

        //혼자타야하는 경우를 제외한 리스트
        List<Integer> pair = peopleList.stream().filter(x -> limit - minWeight >= x).sorted(Collections.reverseOrder()).collect(Collectors.toList());

        answer = people.length - pair.size(); // 짝이 될 수 없는 값

        while (true) {
            int weight = pair.remove(0); //50
            int gap = limit - weight;   //50 -> 45 30

            if (pair.size() == 0) {
                answer++;
            } else if (pair.contains(gap)) {
                pair.remove(Integer.valueOf(gap));
                answer++;
            } else {
                //최대 2명이므로 탈 수 있는 제일 큰 값 찾아서 리턴
                Integer integer = pair.stream().filter(x -> gap > x).findFirst().get();
                pair.remove(integer);
                answer++;
            }
            if (pair.size() == 0) {
                break;
            }
        }
        return answer;
    }
}
