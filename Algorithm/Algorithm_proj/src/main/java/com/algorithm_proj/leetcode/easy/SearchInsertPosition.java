package com.algorithm_proj.leetcode.easy;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {

        // 실패값(num의 길이)으로 초기화
        int answer = nums.length;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {    //같은 값이 있을 경우 answer를 i로 치환하고 종료
                answer = i;
                break;
            }
            if (nums[i] > target) {     //넘었을 경우 target이 있어야 하는 자리로 판단하고 종료
                answer = i;
                break;
            }
        }

        return answer;
    }
}
