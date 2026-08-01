package com.inflearn.javaalgorithms.sec04.q1_두배열합치기;

import java.util.Scanner;

public class MergeSortedArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nArr = new int[n];
        for (int i = 0; i < n; i++) {
            nArr[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] mArr = new int[m];
        for (int i = 0; i < m; i++) {
            mArr[i] = scanner.nextInt();
        }
        MergeSortedArrays mergeSortedArrays = new MergeSortedArrays();
        System.out.println(mergeSortedArrays.solution(n, nArr, m, mArr));
    }

    public String solution(int n, int[] nArr, int m, int[] mArr) {
        StringBuilder sb = new StringBuilder();
        int np = 0;
        int mp = 0;
        while (np < n && mp < m) {
            if (nArr[np] < mArr[mp]) {
                sb.append(nArr[np]).append(" ");
                np++;
            } else {
                sb.append(mArr[mp]).append(" ");
                mp++;
            }
        }
        while (np < n) {
            sb.append(nArr[np]).append(" ");
            np++;
        }
        while (mp < m) {
            sb.append(mArr[mp]).append(" ");
            mp++;
        }
        return sb.toString().trim();
    }
}
