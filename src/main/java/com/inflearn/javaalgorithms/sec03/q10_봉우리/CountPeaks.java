package com.inflearn.javaalgorithms.sec03.q10_봉우리;

import java.util.Scanner;

public class CountPeaks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] grid = new int[n+2][n+2];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        CountPeaks countPeaks = new CountPeaks();
        System.out.println(countPeaks.solution2(n, grid));
    }

    public int solution(int n, int[][] grid) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (grid[i][j] > grid[i - 1][j]
                && grid[i][j] > grid[i + 1][j]
                && grid[i][j] > grid[i][j - 1]
                && grid[i][j] > grid[i][j + 1]) {
                    count++;
                }
            }
        }
        return count;
    }

    public int solution2(int n, int[][] grid) {
        int count = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                boolean isPeak = true;
                for (int d = 0; d < 4; d++) {
                    if (grid[i][j] <= grid[i + dx[d]][j + dy[d]]) {
                        isPeak = false;
                        break;
                    }
                }
                if (isPeak) count++;
            }
        }

        return count;
    }
}
