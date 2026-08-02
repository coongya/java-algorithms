package com.inflearn.javaalgorithms.sec06.q3_크레인인형뽑기;

import java.util.Scanner;
import java.util.Stack;

public class CraneGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = scanner.nextInt();
            }
        }
        int m = scanner.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = scanner.nextInt();
        }
        CraneGame craneGame = new CraneGame();
        System.out.println(craneGame.solution(n, board, m, moves));
    }

    public int solution(int n, int[][] board, int m, int[] moves) {
        int count = 0;
        Stack<Integer> basket = new Stack<>();
        // moves 배열 순회하면서 인형 뽑기
        for (int move : moves) {
            // board의 move - 1열의 위에서부터 아래로 0이 아닌 첫 번째 인형 탐색
            for (int i = 0; i < n; i++) {
                if (board[i][move - 1] != 0) {
                    int temp = board[i][move - 1];
                    board[i][move - 1] = 0;
                    // 바구니의 맨 위의 인형과 일치하면 둘 다 터뜨림
                    if (!basket.isEmpty() && basket.peek() == temp) {
                        count += 2;
                        basket.pop();
                    }
                    // 바구니가 비어있거나 맨 위의 인형과 일치하지 않으면 그냥 인형을 바구니에 쌓기
                    else {
                        basket.push(temp);
                    }
                    break;
                }
            }
        }
        return count;
    }
}
