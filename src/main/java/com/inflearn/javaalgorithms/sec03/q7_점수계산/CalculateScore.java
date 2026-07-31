package com.inflearn.javaalgorithms.sec03.q7_점수계산;

import java.util.Scanner;

public class CalculateScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }
        CalculateScore calculateScore = new CalculateScore();
        System.out.println(calculateScore.solution(n, scores));
    }

    public int solution(int n, int[] scores) {
        int sum = 0;
        int accumulated = 0;
        for (int i = 0; i < n; i++) {
            if (scores[i] == 1) {
                accumulated++;
                sum += accumulated;
            }
            else {
                accumulated = 0;
            }
        }
        return sum;
    }
}
