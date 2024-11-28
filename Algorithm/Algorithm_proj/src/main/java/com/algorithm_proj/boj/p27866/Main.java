package com.algorithm_proj.boj.p27866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    //https://www.acmicpc.net/problem/27866
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String st = br.readLine();
        int n = Integer.parseInt(br.readLine())-1;

        br.close();

        System.out.print(st.charAt(n));
    }
}