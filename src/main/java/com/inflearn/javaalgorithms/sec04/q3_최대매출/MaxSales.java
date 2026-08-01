package com.inflearn.javaalgorithms.sec04.q3_최대매출;

import java.util.Scanner;

public class MaxSales {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] sales = new int[n];
        for (int i = 0; i < n; i++) {
            sales[i] = scanner.nextInt();
        }
        MaxSales maxSales = new MaxSales();
        System.out.println(maxSales.solution(n, k, sales));
    }

    public int solution(int n, int k, int[] sales) {
        int max = 0, sum = 0;
        for (int i = 0; i < k; i++) {
            sum += sales[i];
        }
        max = sum;
        // 한 번만 순회하면서 연속된 k일의 매출액 합계 최대값 찾기
        for (int i = k; i < n; i++) {
            sum += sales[i] - sales[i - k];
            max = Math.max(max, sum);
        }
        return max;
    }
}
