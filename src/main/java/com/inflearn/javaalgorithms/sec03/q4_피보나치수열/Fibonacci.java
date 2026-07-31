package com.inflearn.javaalgorithms.sec03.q4_피보나치수열;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.solution(n));
    }

    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;
        sb.append(arr[0]).append(" ").append(arr[1]).append(" ");
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
            sb.append(arr[i]).append(" ");
        }
        return sb.toString();
    }
}
