package com.algorithm_proj.programmers.level2;

public class Carpet {
    //카펫 - https://school.programmers.co.kr/learn/courses/30/lessons/42842
    //갈과 노란색 격자 갯수를 통해 만들 수 있는 카펫의 크기
    //8 <= brown <= 5,000
    //1 <= yellow <= 2,000,000
    //카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.

    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int totalLength = brown + yellow;
        int sqrt = (int) Math.sqrt(totalLength);

        for (int i = sqrt; i > 0; i--) {
            if (i * i == totalLength && (i - 2) * (i - 2) == yellow) {
                return new int[]{i, i};
            } else if (totalLength % i == 0 && (i - 2) * (totalLength / i - 2) == yellow) {
                return new int[]{totalLength / i, i};
            }
        }
        return answer;
    }
}
