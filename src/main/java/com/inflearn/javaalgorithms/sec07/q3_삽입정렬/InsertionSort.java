package com.inflearn.javaalgorithms.sec07.q3_삽입정렬;

import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        InsertionSort insertionSort = new InsertionSort();
        System.out.println(insertionSort.solution(n, arr));
    }

    public String solution(int n, int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                } else {
                    break;
                }
            }
        }
        for (int i : arr) {
            sb.append(i).append(" ");
        }
        return sb.toString();
    }
}
