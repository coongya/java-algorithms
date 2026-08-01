package com.inflearn.javaalgorithms.sec04.q4_연속부분수열;

import java.util.Scanner;

public class CountSubarraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        CountSubarraySum countSubarraySum = new CountSubarraySum();
        System.out.println(countSubarraySum.solution(n, m, array));
    }

    public int solution(int n, int m, int[] array) {
        int count = 0;
        int sum = 0;
        int lt = 0;
        for (int rt = 0; rt < n; rt++) {
            sum += array[rt];
            while (sum > m) {
                sum -= array[lt++];
            }
            if (sum == m) {
                count++;
            }
        }
        return count;
    }
}
