package com.inflearn.javaalgorithms.sec03.q9_격자판최대합;

import java.util.Scanner;

public class MaxSumInGrid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        MaxSumInGrid maxSumInGrid = new MaxSumInGrid();
        System.out.println(maxSumInGrid.solution(n, grid));
    }

    public int solution(int n, int[][] grid) {
        int max = 0;
        // 가로합, 세로합
        for (int i = 0; i < n; i++) {
            int sum1 = 0, sum2 = 0;
            for (int j = 0; j < n; j++) {
                sum1 += grid[i][j];
                sum2 += grid[j][i];
            }
            max = Math.max(max, sum1);
            max = Math.max(max, sum2);
        }
        // 대각선합
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += grid[i][i];
            sum2 += grid[i][n - 1 - i];
        }
        max = Math.max(max, sum1);
        max = Math.max(max, sum2);

        return max;
    }
}
