package com.algorithm_proj.programmers.level1;

public class WeaponsForTempler {
    // 기사단원의 무기 - https://school.programmers.co.kr/learn/courses/30/lessons/136798
    // 1~n까지의 숫자를 가지고 각 기사는 약수 갯수만큼의 공격력을 가진 무기를 구매
    // 최대 공격력은 협약에 의해 정해져 있음.
    // 최종적으로 쓰일 무기 공격력의 양을 계산하여 무기를 만들때 필요한 철의 무게를 계산하기 위함.
    // 무기 공격력 1당 kg의 철이 필요함.

    public int solution(int number, int limit, int power) {
        int answer = 0;
        // 각 기사단 약수용 어레이
        int[] count = new int[number + 1]; // 0 사용하지 않음.

        for (int i = 1; i <= number; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (j * j == i) count[i]++;
                else if (i % j == 0) count[i] += 2;
            }
        }
        for (int i = 1; i < count.length; i++) {
            if (count[i] > limit) {
                answer += power;
            } else {
                answer += count[i];
            }
        }
        return answer;
    }
}
