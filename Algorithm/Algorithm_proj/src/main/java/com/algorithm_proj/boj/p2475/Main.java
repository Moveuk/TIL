package com.algorithm_proj.boj.p2475;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    //https://www.acmicpc.net/problem/2475
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            int temp = scanner.nextInt();
            sum += temp * temp;
        }

        int result = sum % 10;
        System.out.println(result);
    }
}