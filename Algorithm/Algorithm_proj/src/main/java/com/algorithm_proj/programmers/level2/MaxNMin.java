package com.algorithm_proj.programmers.level2;

import java.util.StringTokenizer;

public class MaxNMin {
    //최댓값과 최솟값 - https://school.programmers.co.kr/learn/courses/30/lessons/12939
    //string s에는 공백으로 구분된 숫자가있음. 이중 최소 최대 값을 반환하는 함수 완성

    public String solution(String s) {
        String answer = "";
        StringTokenizer st = new StringTokenizer(s, " ");
        int token = Integer.parseInt(st.nextToken());
        int[] arrAnswer = new int[]{token, token}; //min max array

        while (st.hasMoreTokens()) {
            token = Integer.parseInt(st.nextToken());
            arrAnswer[0] = Math.min(arrAnswer[0], token);
            arrAnswer[1] = Math.max(arrAnswer[1], token);
        }
        answer += arrAnswer[0] + " " + arrAnswer[1];

        return answer;
    }

}
