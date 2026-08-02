package com.inflearn.javaalgorithms.sec05.q5_K번째큰수;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class KthLargestNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        KthLargestNumber kth = new KthLargestNumber();
        System.out.println(kth.solution(n, m, arr));
    }

    public int solution(int n, int m, int[] arr) {
        int answer = -1;
        TreeSet<Integer> treeSet = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    treeSet.add(arr[i] + arr[j] + arr[k]);
                }
            }
        }
        int count = 0;
        for (Integer integer : treeSet) {
            count++;
            if (count == m) {
                return integer;
            }
        }
        return answer;
    }
}
