package com.inflearn.javaalgorithms.sec04.q2_공통원소구하기;

import java.util.Arrays;
import java.util.Scanner;

public class FindCommonElements {
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
        FindCommonElements findCommonElements = new FindCommonElements();
        System.out.println(findCommonElements.solution(n, nArr, m, mArr));
    }

    public String solution(int n, int[] nArr, int m, int[] mArr) {
        StringBuilder sb = new StringBuilder();
        // 두 배열을 오름차순으로 정렬
        Arrays.sort(nArr);
        Arrays.sort(mArr);
        // Two pointers
        int np = 0, mp = 0;
        while (np < n && mp < m) {
            // 공통원소만 출력
            if (nArr[np] == mArr[mp]) {
                sb.append(nArr[np]).append(" ");
                np++;
                mp++;
            } else if (nArr[np] < mArr[mp]) {
                np++;
            } else {
                mp++;
            }
        }
        return sb.toString();
    }
}
