package com.algorithm_proj.leetcode.easy;

public class RomanToInt {
    public int romanToInt(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            int tmp1 = RomanSymbols.valueOf(s.substring(i, i + 1)).value;
            if (i != s.length() - 1) {
                int tmp2 = RomanSymbols.valueOf(s.substring(i + 1, i + 2)).value;

                if (tmp1 >= tmp2) {
                    answer += tmp1;
                } else {
                    answer += tmp2 - tmp1;
                    i++;
                }
            } else {
                answer += tmp1;
            }

        }

        return answer;
    }

    enum RomanSymbols {
        I(1),
        V(5),
        X(10),
        L(50),
        C(100),
        D(500),
        M(1000);

        private int value;

        RomanSymbols(int value) {
            this.value = value;
        }
    }
}
