package com.inflearn.javaalgorithms.sec03.q1_큰수출력하기;

import java.util.Scanner;

public class PrintGreaterNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        PrintGreaterNumbers printGreaterNumbers = new PrintGreaterNumbers();
        System.out.println(printGreaterNumbers.solution(n, arr));
    }

    public String solution(int n, int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]).append(" ");
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i-1]) {
                sb.append(arr[i]).append(" ");
            }
        }
        return sb.toString();
    }
}
