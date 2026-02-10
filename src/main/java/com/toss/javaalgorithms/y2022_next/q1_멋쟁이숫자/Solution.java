package com.toss.javaalgorithms.y2022_next.q1_멋쟁이숫자;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("=== fancyNumber ===");
        System.out.println(solution.fancyNumber("12223"));      // 222
        System.out.println(solution.fancyNumber("111999333"));  // 999
        System.out.println(solution.fancyNumber("123"));        // -1
        System.out.println("=== fancyNumber2 ===");
        System.out.println(solution.fancyNumber2("12223"));     // 222
        System.out.println(solution.fancyNumber2("111999333")); // 999
        System.out.println(solution.fancyNumber2("123"));       // -1
        System.out.println(solution.fancyNumber2("000123"));    // 0
        System.out.println(solution.fancyNumber2(""));          // -1
    }

    // 풀이: 슬라이딩 윈도우로 길이 3인 substring을 순회하며 세 자리가 모두 같은지 체크
    // 시간 복잡도: O(n) - 문자열을 한 번 순회 (n = s.length)
    // 공간 복잡도: O(1) - 고정된 변수만 사용
    public int fancyNumber(String s) {
        // 멋쟁이 숫자의 최대값 저장, -1이면 존재하지 않음
        int max = -1;
        for (int i = 0; i < s.length() - 2; i++) {
            // 연속 3자리가 모두 같은 숫자인지 확인
            if (s.charAt(i) == s.charAt(i + 1) && s.charAt(i + 1) == s.charAt(i + 2)) {
                // substring을 정수로 변환하여 비교 (e.g. "999" → 999, "000" → 0)
                max = Math.max(max, Integer.parseInt(s.substring(i, i + 3)));
            }
        }
        // 멋쟁이 숫자가 존재하지 않으면 -1, "000"이 최대면 0, 그 외는 최대값 그대로 리턴
        return max;
    }

    // 풀이: 순수 산술 연산으로 멋쟁이 숫자를 계산
    // - fancyNumber: 매번 s.substring()으로 힙 메모리에 새 String 객체 생성 + Integer.parseInt() 파싱
    // - fancyNumber2: char 연산 (s.charAt(i) - '0')과 곱셈 (* 111)만 사용 → 객체 생성 없음
    // 시간 복잡도: O(n) - 문자열을 한 번 순회 (n = s.length)
    // 공간 복잡도: O(1) - substring 임시 객체 생성이 없으므로 진정한 O(1)
    public int fancyNumber2(String s) {
        int max = -1;
        for (int i = 0; i < s.length() - 2; i++) {
            if (s.charAt(i) == s.charAt(i + 1) && s.charAt(i + 1) == s.charAt(i + 2)) {
                // '0'~'9' → 0~9 변환 후 * 111로 멋쟁이 숫자 계산
                // e.g. '9' - '0' = 9, 9 * 111 = 999
                // e.g. '0' - '0' = 0, 0 * 111 = 0
                max = Math.max(max, (s.charAt(i) - '0') * 111);
            }
        }
        return max;
    }
}
