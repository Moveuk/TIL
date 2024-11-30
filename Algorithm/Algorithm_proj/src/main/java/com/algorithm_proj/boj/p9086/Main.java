package com.algorithm_proj.boj.p9086;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    //https://www.acmicpc.net/problem/9086
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String name[] = new String[n];

        for(int i=0;i<n;i++) {
            String str = br.readLine();
            name[i] = str.substring(0,1)+str.substring(str.length()-1,str.length());
        }
        br.close();
        for(int i=0;i<n;i++) {
            System.out.println(name[i]);
        }
    }
}