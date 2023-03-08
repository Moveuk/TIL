package com.algorithm_proj.leetcode.easy;

import java.util.HashSet;
import java.util.Iterator;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        //null이 아닌 array nums 이 들어온다.
        //하나 빼고는 모두 쌍으로 존재한다.

        //접근법
        //1. hashSet에 저장해서 없으면 저장해두고 있으면 빼도록 설정
        // set 중복, 정렬 되지 않음.
        // hash 양에 상관없이 일정하게 n의 시간복잡도를 가짐

        HashSet<Integer> set = new HashSet<>();

        for (int i : nums) {
            if (set.contains(i)) {
                set.remove(i);
            } else {
                set.add(i);
            }
        }

        Iterator<Integer> iterator = set.iterator();

        return iterator.next();
    }

    public static void main(String[] args) {

        SingleNumber sn = new SingleNumber();

        int s = sn.singleNumber(new int[]{2, 2, 1});

        System.out.println(s);
    }
}
