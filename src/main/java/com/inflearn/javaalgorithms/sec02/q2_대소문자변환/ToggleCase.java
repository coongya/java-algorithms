package com.inflearn.javaalgorithms.sec02.q2_대소문자변환;

import java.util.Scanner;

public class ToggleCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        ToggleCase toggleCase = new ToggleCase();
        System.out.println(toggleCase.solution(input));
    }

    public String solution(String input) {
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                sb.append((char) (c + 32));
            } else if (c >= 'a' && c <= 'z') {
                sb.append((char) (c - 32));
            }
        }
        return sb.toString();
    }

    public String solution2(String input) {
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(Character.toUpperCase(c));
            }
        }
        return sb.toString();
    }
}
