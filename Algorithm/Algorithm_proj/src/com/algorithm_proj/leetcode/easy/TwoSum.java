package com.algorithm_proj.leetcode.easy;

public class TwoSum {
    // 주어진 nums 배열에서 2 수를 빼서 더했을 때 target 이 되는 한쌍의 위치 값을 리턴하라

    // 1. 선택 정렬처럼 이중 for문으로 각 요소를 선택한다.

    // 2. 두개를 더하여 target이랑 비교.

    // 3. 같으면 break return

    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    answer[0] = i;
                    answer[1] = j;
                    break;
                }
            }
        }

        return answer;
    }

    // hashtable로 시간복잡도를 n으로 만드는 방법이 있음.
    // 해쉬맵에 모든 num을 배열번호를 키값 값을 value 값에 넣음.
    // 0번 째부터 for문을 돌리는데 complement target에서 i번째 배열값을 뺀 값을 구해서 그 값이 hash에 존재하는지 확인함.
}
