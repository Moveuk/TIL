package com.algorithm_proj.boj.p1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    //https://www.acmicpc.net/problem/1978
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();	// N 은 쓰지 않음.
        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        while(st.hasMoreTokens()) {

            // 소수인경우 true, 아닌경우 false
            boolean isPrime = true;

            int num = Integer.parseInt(st.nextToken());

            if(num == 1) {
                continue;
            }
            for(int i = 2; i <= Math.sqrt(num); i++) {
                if(num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                count++;
            }
        }
        System.out.println(count);
    }

}