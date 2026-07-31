package com.inflearn.javaalgorithms.sec03.q6_뒤집은소수;

import java.util.Scanner;

public class ReversedPrimes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        ReversedPrimes reversedPrimes = new ReversedPrimes();
        System.out.println(reversedPrimes.solution(n, arr));
    }

    public String solution(int n, int[] arr) {
        StringBuilder sb = new StringBuilder();
        // 숫자 뒤집기
        for (int i = 0; i < n; i++) {
            int reversed = 0;
            while (arr[i] > 0) {
                reversed = reversed * 10 + arr[i] % 10;
                arr[i] /= 10;
            }
            arr[i] = reversed;
        }
        // 소수 판별
        for (int i = 0; i < n; i++) {
            if (isPrime(arr[i])) sb.append(arr[i]).append(" ");
        }
        return sb.toString();
    }

    private boolean isPrime(int n) {
        if (n == 1) return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private boolean isPrime2(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
