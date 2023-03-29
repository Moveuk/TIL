package com.algorithm_proj.programmers.level2;

import java.util.Stack;

public class CorrectBracket {
    //올바른 괄호 - https://school.programmers.co.kr/learn/courses/30/lessons/12909
    //"()()" 또는 "(())()" 는 올바른 괄호입니다.
    //")()(" 또는 "(()(" 는 올바르지 않은 괄호입니다.

    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 40) {
                stack.push(c);
            } else if (c == 41) {
                if (stack.empty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.empty();
    }
}
