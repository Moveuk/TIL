package com.algorithm_proj.boj.p2754;

import java.util.Scanner;

public class Main {
    //https://www.acmicpc.net/problem/2754
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String score = scanner.next();

        double answer = 0.0;

        if (score.equals("F")) {
            System.out.print(answer);
            return;
        }
        answer += 69 - score.charAt(0); // 아스키 E - (A || B || C || D || E)

        switch (score.charAt(1)) { // +. - 분류
            case '+':
                answer += 0.3;
                break;
            case '-':
                answer -= 0.3;
        }

        System.out.print(answer);
    }
}