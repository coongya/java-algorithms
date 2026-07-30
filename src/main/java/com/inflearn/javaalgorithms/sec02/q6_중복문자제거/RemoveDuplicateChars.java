package com.inflearn.javaalgorithms.sec02.q6_중복문자제거;

import java.util.Scanner;

public class RemoveDuplicateChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        RemoveDuplicateChars removeDuplicateChars = new RemoveDuplicateChars();
        System.out.println(removeDuplicateChars.solution(input));
    }

    public String solution(String input) {
        String answer = "";
        for (int i = 0; i < input.length(); i++) {
            if (input.indexOf(input.charAt(i)) == i) {
                answer += input.charAt(i);
            }
        }
        return answer;
    }
}
