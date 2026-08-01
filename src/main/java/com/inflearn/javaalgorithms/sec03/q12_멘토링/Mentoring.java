package com.inflearn.javaalgorithms.sec03.q12_멘토링;

import java.util.Scanner;

public class Mentoring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        Mentoring mentoring = new Mentoring();
        System.out.println(mentoring.solution(n, m, grid));
    }

    // 모든 학생 쌍 (i, j)에 대해 m번의 테스트 전부 i가 j보다 등수가 앞섰는지 확인하는 완전 탐색
    public int solution(int n, int m, int[][] grid) {
        int answer = 0;
        // 멘토, 멘티 (i, j) 쌍 탐색
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // m번의 테스트에 대해 확인
                int count = 0;
                for (int k = 0; k < m; k++) {
                    // 학생 수 n에 대해 확인
                    int iRank = 0;
                    int jRank = 0;
                    for (int s = 0; s < n; s++) {
                        if (grid[k][s] == i) iRank = s;
                        if (grid[k][s] == j) jRank = s;
                    }
                    if (iRank < jRank) count++;
                }
                if (count == m) answer++;
            }
        }
        return answer;
    }
}
