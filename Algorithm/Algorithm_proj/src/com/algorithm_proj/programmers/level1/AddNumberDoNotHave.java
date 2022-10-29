package com.algorithm_proj.programmers.level1;

public class AddNumberDoNotHave {
    // 없는 숫자 더하기 - https://school.programmers.co.kr/learn/courses/30/lessons/86051
    // 0부터 9까지의 숫자 중 일부가 들어있는 정수 배열 numbers가 매개변수로 주어집니다.
    // numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return 하도록 solution 함수를 완성해주세요.

    public int solution(int[] numbers) {
        // 없는 숫자란 결국 총 합 45에서 들어오는 numbers를 하나씩 빼준 값을 의미함.
        int answer = 45;

        for (int i : numbers) {
            answer -= i;
        }

        return answer;
    }
}
