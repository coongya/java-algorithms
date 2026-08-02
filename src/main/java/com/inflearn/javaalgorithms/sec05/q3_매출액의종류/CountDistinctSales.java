package com.inflearn.javaalgorithms.sec05.q3_매출액의종류;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountDistinctSales {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        CountDistinctSales countDistinctSales = new CountDistinctSales();
        System.out.println(countDistinctSales.solution(n, k, arr));
    }

    public String solution(int n, int k, int[] arr) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        sb.append(map.size()).append(" ");
        int lt = 0;
        for (int rt = k; rt < n; rt++) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            map.put(arr[lt], map.get(arr[lt]) - 1);
            // 주의: 해당 키의 값이 0이면 HashMap에서 해당 키를 삭제해주어야 카운팅에서 빠짐
            if (map.get(arr[lt]) == 0) map.remove(arr[lt]);
            lt++;
            sb.append(map.size()).append(" ");
        }
        return sb.toString();
    }
}
