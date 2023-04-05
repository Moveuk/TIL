package com.algorithm_proj.programmers.level2;

import java.util.Stack;

public class DeletePairs {
    //짝지어 제거하기 - https://school.programmers.co.kr/learn/courses/30/lessons/12973

    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            stack.push(s.charAt(i));
            if (stack.size() < 2) {
                if (i == s.length() - 1) break;
                stack.push(s.charAt(i++ + 1));
            }

            if (stack.get(stack.size() - 1) == stack.get(stack.size() - 2)) {
                stack.pop();
                stack.pop();
            }
        }

        if (stack.empty()) {
            return 1;
        }
        return 0;
    }

    public int solution3(String s) {
        StringBuilder sb = new StringBuilder(s);
        int index = 0;
        int cnt = 0;
        boolean isSameAsBefore = true;

        while (true) {
            if (sb.length() == 0) {
                return 1;
            } else if (sb.length() < 2 || index == sb.length() - 1) {
                return 0;
            } else if (s.length() / 2 == cnt) {
                return 0;
            }
            if (sb.charAt(index) == sb.charAt(index + 1)) {
                sb.delete(index, index + 2);
                isSameAsBefore = false;
            }
            if (isSameAsBefore) {
                index++;
                isSameAsBefore = true;
            } else {
                if (index > 0) index--;
                cnt++;
            }
        }
    }

    public int solution2(String s) {
        StringBuilder sb = new StringBuilder(s);
        StringBuilder container = new StringBuilder();
        String comparison = s;

        while (true) {

            container.append(sb.charAt(0));
            sb.deleteCharAt(0);

            if (container.length() < 2) {
                container.append(sb.charAt(0));
                sb.deleteCharAt(0);
            }

            if (container.charAt(container.length() - 1)
                    == container.charAt(container.length() - 2)) {
                container.deleteCharAt(container.length() - 1);
                container.deleteCharAt(container.length() - 1);
            }

            if (sb.length() == 0 && container.length() == 0) {
                return 1;
            }
            if (sb.length() == 0) {
                comparison = container.toString();
                sb = new StringBuilder(container);
                container = new StringBuilder();
            }
            if (comparison.equals(sb.toString())) {
                return 0;
            }
        }
    }
}
