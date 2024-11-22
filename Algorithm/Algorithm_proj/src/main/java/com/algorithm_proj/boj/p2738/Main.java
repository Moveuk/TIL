package com.algorithm_proj.boj.p2738;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    //https://www.acmicpc.net/problem/2738
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int i,j;

        int n = sc.nextInt();
        int m = sc.nextInt();

        int a[][] = new int[n][m];
        int b[][] = new int[n][m];
        int sum[][] = new int[n][m];

        for(i=0;i<n;i++) {
            for(j=0;j<m;j++) {
                a[i][j] = sc.nextInt();
            }
        }
        for(i=0;i<n;i++) {
            for(j=0;j<m;j++) {
                b[i][j] = sc.nextInt();
            }
        }

        sc.close();

        for(i=0;i<n;i++) {
            for(j=0;j<m;j++) {
                sum[i][j] = a[i][j] + b[i][j];
            }
        }

        IntStream.range(0, n).forEach(x -> {
            IntStream.range(0, m)
                    .forEach(y -> System.out.print(sum[x][y] + (y == m - 1 ? "" : " ")));
            System.out.println();
        });

    }
}