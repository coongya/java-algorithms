package com.inflearn.javaalgorithms.sec07.q2_버블정렬;

import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        BubbleSort bubbleSort = new BubbleSort();
        System.out.println(bubbleSort.solution(n, arr));
    }

    public String solution(int n, int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            // 뒤쪽 i개는 이미 확정
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i : arr) {
            sb.append(i).append(" ");
        }
        return sb.toString();
    }
}
