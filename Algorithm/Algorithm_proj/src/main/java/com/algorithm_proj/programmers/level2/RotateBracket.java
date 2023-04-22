package com.algorithm_proj.programmers.level2;

import java.util.Stack;

public class RotateBracket {
    //괄호 회전하기 - https://school.programmers.co.kr/learn/courses/30/lessons/76502

    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            if (isCorrectBracket(s)) {
                answer++;
            }
            String firstChar = s.substring(0, 1);
            s = s.substring(1);
            s += firstChar;
        }

        return answer;
    }

    //Check the bracket
    boolean isCorrectBracket(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 40 || c == 123 || c == 91) {
                stack.push(c);
            } else if (c == 41 || c == 125 || c == 93) {
                if (stack.empty()) {
                    return false;
                }

                char endBracket = switch (c) {
                    case 41 -> 40;
                    case 93 -> 91;
                    case 125 -> 123;
                    default -> 0;
                };

                if (stack.peek() == endBracket) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.empty();
    }
}
