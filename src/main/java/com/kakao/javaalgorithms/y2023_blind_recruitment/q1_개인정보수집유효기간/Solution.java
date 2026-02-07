package com.kakao.javaalgorithms.y2023_blind_recruitment.q1_개인정보수집유효기간;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    // 시간 복잡도 : O(n + m) terms와 privacies 길이만큼 순회
    // 공간 복잡도 : O(n + m) termMap과 result 리스트
    public int[] solution(String today, String[] terms, String[] privacies) {
        // 오늘 날짜를 정수로 변환
        int todayInt = toInt(today);
        // 약관 종류별 유효기간
        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] termArray = term.split(" ");
            termMap.put(termArray[0], Integer.parseInt(termArray[1]));
        }
        // 개인정보 파기 여부 결정
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] privacyArray = privacies[i].split(" ");
            int collectDay = toInt(privacyArray[0]);
            int destroyDay = collectDay + (termMap.get(privacyArray[1]) * 28);
            if (todayInt >= destroyDay) {
                result.add(i + 1);
            }
        }
        // 파기해야 할 개인정보의 번호를 배열로 반환
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private int toInt(String date) {
        String[] dateArray = date.split("\\.");
        int year = Integer.parseInt(dateArray[0]);
        int month = Integer.parseInt(dateArray[1]);
        int day = Integer.parseInt(dateArray[2]);
        return (year * 12 * 28) + (month * 28) + day;
    }
}
