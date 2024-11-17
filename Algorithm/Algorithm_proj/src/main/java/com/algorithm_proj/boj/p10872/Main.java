package com.algorithm_proj.boj.p10872;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    //https://www.acmicpc.net/problem/10872

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int sum = factorial(N);
        System.out.print(sum);
    }

    public static int factorial(int N) {
        if(N <= 1) return 1;	// 재귀 종료조건
        return N * factorial(N - 1);
    }
}
