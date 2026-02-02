package com.kakao.javaalgorithms.y2024_winter_internship.q1_가장많이받은선물;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        // 친구 수
        int count = friends.length;
        // 이름과 배열 인덱스 매핑
        Map<String, Integer> nameMap = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            nameMap.put(friends[i], i);
        }
        // 주고받은 선물 내역 2차원 배열
        int[][] array = new int[count][count];
        for (String gift : gifts) {
            String[] arr = gift.split(" ");
            array[nameMap.get(arr[0])][nameMap.get(arr[1])] += 1;
        }
        // 선물 지수
        int[] index = new int[count];
        for (int i=0; i<count; i++) {
            int give = 0;
            int receive = 0;
            for (int j=0; j<count; j++) {
                give += array[i][j];
                receive += array[j][i];
            }
            index[i] = give - receive;
        }
        // 받을 선물 카운팅용 배열
        int[] gift = new int[count];
        // 선물 받을 사람 결정 및 선물 수 카운팅
        for (int i=0; i<count; i++) {
            for (int j=0; j<count; j++) {
                if (i == j) continue;
                if (array[i][j] > array[j][i]) {
                    gift[i] += 1;
                } else if (array[i][j] == array[j][i] && index[i] > index[j]) {
                    gift[i] += 1;
                }
            }
        }
        // 최대값 리턴
        answer = gift[0];
        for (int i=0; i<count; i++) {
            if (answer < gift[i]) {
                answer = gift[i];
            }
        }
        return answer;
    }
}
