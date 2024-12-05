package com.algorithm_proj.boj.p4153;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    //https://www.acmicpc.net/problem/4153
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[3];
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            arr[2] = Integer.parseInt(st.nextToken());

            //정렬
            Arrays.sort(arr);

            double A = Math.pow(arr[0], 2);
            double B = Math.pow(arr[1], 2);
            double C = Math.pow(arr[2], 2);

            if(A == 0 && B == 0 && C == 0) {
                break;
            }

            if(A + B == C) {
                System.out.println("right");
            }else {
                System.out.println("wrong");
            }
        }
    }

}