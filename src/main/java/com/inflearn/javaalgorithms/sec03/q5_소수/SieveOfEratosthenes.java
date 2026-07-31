package com.inflearn.javaalgorithms.sec03.q5_소수;

import java.util.Scanner;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        SieveOfEratosthenes sieve = new SieveOfEratosthenes();
        System.out.println(sieve.solution(n));
    }

    public int solution(int n) {
        int count = 0;
        int[] arr = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            // 인덱스가 i인 배열값이 0이면 i를 소수로 카운팅, i의 배수들은 소수가 아니므로 값을 전부 1로 변경해줌
            if (arr[i] == 0) {
                count++;
                for (int j = i; j <= n; j += i) {
                    arr[j] = 1;
                }
            }
        }
        return count;
    }
}
