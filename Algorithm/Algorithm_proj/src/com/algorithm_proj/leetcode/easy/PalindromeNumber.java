package com.algorithm_proj.leetcode.easy;

public class PalindromeNumber {
    // 숫자 x를 뒤집어도 같은 숫자인지 확인하는 것.
    public boolean isPalindrome(int x) {
        String tmp = "";
        String s = String.valueOf(x);
        String[] sarray = s.split("");

        for (int i = sarray.length-1; i > -1; i--) {
            tmp += sarray[i];
        }

        if (s.equals(tmp)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromeNumber().isPalindrome(121));
    }
}
