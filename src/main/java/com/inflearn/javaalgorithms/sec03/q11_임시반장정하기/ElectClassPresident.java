package com.inflearn.javaalgorithms.sec03.q11_임시반장정하기;

import java.util.Scanner;

public class ElectClassPresident {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] grid = new int[n][5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        ElectClassPresident electClassPresident = new ElectClassPresident();
        System.out.println(electClassPresident.solution(n, grid));
    }

    public int solution(int n, int[][] grid) {
        int president = 0;
        int max = Integer.MIN_VALUE;
        // i+1번 학생 계산
        for (int i = 0; i < n; i++) {
            int count = 0;
            // j+1번 학생과 같은 반 여부 확인
            for (int j = 0; j < n; j++) {
                // 자기 자신은 제외
                if (i == j) continue;
                // 1-5학년 확인
                for (int k = 0; k < 5; k++) {
                    if (grid[i][k] == grid[j][k]) {
                        count++;
                        break;
                    }
                }
            }
            if (count > max) {
                max = count;
                president = i + 1;
            }
        }
        return president;
    }
}
