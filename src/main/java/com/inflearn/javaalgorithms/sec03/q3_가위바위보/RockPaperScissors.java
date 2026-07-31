package com.inflearn.javaalgorithms.sec03.q3_가위바위보;

import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        RockPaperScissors rockPaperScissors = new RockPaperScissors();
        System.out.println(rockPaperScissors.solution2(n, a, b));
    }

    public String solution(int n, int[] a, int[] b) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (a[i] == b[i]) {
                sb.append("D");
            } else if (a[i] - 1 == b[i]) {
                sb.append("A");
            } else if (a[i] - 2 == b[i]) {
                sb.append("B");
            } else if (b[i] - 1 == a[i]) {
                sb.append("B");
            } else if (b[i] - 2 == a[i]) {
                sb.append("A");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public String solution2(int n, int[] a, int[] b) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            // 무승부
            if (a[i] == b[i]) sb.append("D");

            // A가 이기는 경우
            else if (
                    (a[i] == 1 && b[i] == 3) // A가 가위로 이기는 경우
                    || (a[i] == 2 && b[i] == 1) // A가 바위로 이기는 경우
                    || (a[i] == 3 && b[i] == 2) // A가 보로 이기는 경우
            ) sb.append("A");

            // 그 외에는 다 B가 이기는 경우
            else sb.append("B");

            sb.append("\n");
        }
        return sb.toString();
    }
}
