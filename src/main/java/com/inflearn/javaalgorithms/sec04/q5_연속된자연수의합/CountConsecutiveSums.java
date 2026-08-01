package com.inflearn.javaalgorithms.sec04.q5_연속된자연수의합;

import java.util.Scanner;

public class CountConsecutiveSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        CountConsecutiveSums count = new CountConsecutiveSums();
        System.out.println(count.solution(n));
    }

    // Two pointers
    public int solution(int n) {
        int count = 0;
        int sum = 0, lt = 1;
        for (int rt = 1; rt < n; rt++) {
            sum += rt;
            while (sum > n) {
                sum -= lt++;
                if (sum == n) count++;
            }
        }
        return count;
    }

    // 수학적 풀이
    public int solution2(int n) {
        int count = 0;
        int c = 1; // 연속된 자연수의 개수
        n -= c;
        while (n > 0) {
            c++;
            n -= c;
            if (n % c == 0) count++;
        }
        return count;
    }
}
