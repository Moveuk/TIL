package com.algorithm_proj.programmers.level1;

public class NumberAndWords {
    // 숫자 문자열과 영단어 - https://school.programmers.co.kr/learn/courses/30/lessons/81301
    // 네오와 프로도가 숫자놀이를 하고 있습니다.
    // 네오가 프로도에게 숫자를 건넬 때 일부 자릿수를 영단어로 바꾼 카드를 건네주면 프로도는 원래 숫자를 찾는 게임입니다.
    //
    //다음은 숫자의 일부 자릿수를 영단어로 바꾸는 예시입니다.
    //
    // 1478 → "one4seveneight"
    // 234567 → "23four5six7"
    // 10203 → "1zerotwozero3"
    //
    // 이렇게 숫자의 일부 자릿수가 영단어로 바뀌어졌거나, 혹은 바뀌지 않고 그대로인 문자열 s가 매개변수로 주어집니다.
    // s가 의미하는 원래 숫자를 return 하도록 solution 함수를 완성해주세요.
    public int solution(String s) {

        final String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        final String[] alphabetNumbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String response = s;

        for (int i = 0; i < 10; i++) {
            response = response.replace(alphabetNumbers[i], numbers[i]);
        }

        return Integer.parseInt(response);
    }
}
