package com.algorithm_proj.boj.p2743;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    //https://www.acmicpc.net/problem/2743
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String st = br.readLine();
        br.close();

        System.out.print(st.length());
    }
}