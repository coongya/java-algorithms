package com.inflearn.javaalgorithms.sec02.q10_가장짧은문자거리;

import java.util.Scanner;

public class ShortestDistanceToChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        char c = scanner.next().charAt(0);
        ShortestDistanceToChar sd = new ShortestDistanceToChar();
        System.out.println(sd.solution(s, c));
    }

    // 양방향 스캔(Two Pass)
    public String solution(String s, char c) {
        int[] answer = new int[s.length()];
        int p = 1000;
        // 1차 스캔: 왼쪽 -> 오른쪽
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                p = 0;
            } else {
                p++;
            }
            answer[i] = p;
        }
        p = 1000;
        // 2차 스캔: 오른쪽 -> 왼쪽
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                p = 0;
            } else {
                p++;
            }
            answer[i] = Math.min(p, answer[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i : answer) {
            sb.append(i).append(" ");
        }
        return sb.toString().trim();
    }
}
