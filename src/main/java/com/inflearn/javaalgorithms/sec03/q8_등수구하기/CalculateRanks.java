package com.inflearn.javaalgorithms.sec03.q8_등수구하기;

import java.util.*;

public class CalculateRanks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }
        CalculateRanks calc = new CalculateRanks();
        for (int rank : calc.solution(n, scores)) {
            System.out.print(rank + " ");
        }
    }

    // 이중 for문 돌면서 등수 구하기
    public int[] solution(int n, int[] scores) {
        int[] ranks = new int[n];
        for (int i = 0; i < n; i++) {
            int rank = 1;
            for (int j = 0; j < n; j++) {
                // 자기 점수보다 높은 점수 있을 때마다 등수 1씩 낮아짐
                if (scores[i] < scores[j]) {
                    rank++;
                }
            }
            ranks[i] = rank;
        }
        return ranks;
    }
}
