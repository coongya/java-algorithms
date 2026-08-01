package com.inflearn.javaalgorithms.sec04.q6_최대길이연속부분수열;

import java.util.Scanner;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        MaxConsecutiveOnes maxConsecutiveOnes = new MaxConsecutiveOnes();
        System.out.println(maxConsecutiveOnes.solution(n, k, arr));
    }

    public int solution(int n, int k, int[] arr) {
        int max = 0;
        int zeroCount = 0, lt = 0;
        for (int rt = 0; rt < n; rt++) {
            if (arr[rt] == 0) zeroCount++;
            while (zeroCount > k) {
                if (arr[lt] == 0) {
                    zeroCount--;
                }
                lt++;
            }
            max = Math.max(max, rt - lt + 1);
        }
        return max;
    }
}
