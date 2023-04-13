package com.algorithm_proj.programmers.level2;

public class JumpNTeleport {
    //점프와 순간 이동 - https://school.programmers.co.kr/learn/courses/30/lessons/12980

    public int solution(int n) {
        int ans = 0;

        while (true) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                break;
            }
        }

        ans = Integer.bitCount(n);

        return ans;
    }
}
