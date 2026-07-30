package com.inflearn.javaalgorithms.sec02.q9_숫자만추출;

import java.util.Scanner;

public class ExtractDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        ExtractDigits extractDigits = new ExtractDigits();
        System.out.println(extractDigits.solution(s));
    }

    public int solution(String s) {
        int answer = 0;
        for (char c : s.toCharArray()) {
            // char '0' = 48, '9' = 57
            if (c >= '0' && c <= '9') {
                answer = answer * 10 + (c - '0');
            }
        }
        return answer;
    }

    public int solution2(String s) {
        String answer = "";
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                answer += c;
            }
        }
        return Integer.parseInt(answer);
    }
}
