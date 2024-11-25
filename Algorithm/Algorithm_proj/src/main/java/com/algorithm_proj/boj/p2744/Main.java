package com.algorithm_proj.boj.p2744;

import java.util.*;

public class Main {
    //https://www.acmicpc.net/problem/2744
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLowerCase(c)) {
                c = Character.toUpperCase(c);
            }
            else if (Character.isUpperCase(c))
                c = Character.toLowerCase(c);
            System.out.print(c);
        }
    }
}