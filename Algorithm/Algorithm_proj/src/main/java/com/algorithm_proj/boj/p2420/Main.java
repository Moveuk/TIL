package com.algorithm_proj.boj.p2420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
// https://www.acmicpc.net/problem/2420
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Long N = Long.parseLong(st.nextToken());
        Long M = Long.parseLong(st.nextToken());

        System.out.print(Math.abs(N - M));
    }
}
