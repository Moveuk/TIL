package com.algorithm_proj.boj.p10807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //https://www.acmicpc.net/problem/10807

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer integers = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(br.readLine());
        int count = 0;

        while (integers.hasMoreTokens()) {
            int i = Integer.parseInt(integers.nextToken());
            if (v == i) count++;
        }

        System.out.print(count);
    }
}
