package com.inflearn.javaalgorithms.sec02.q8_유효한팰린드롬;

import java.util.Scanner;

public class ValidPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.solution(s));
    }

    public String solution(String s) {
        s = s.replaceAll("[^A-Za-z]", "");
        String reversed = new StringBuilder(s).reverse().toString();
        if (s.equalsIgnoreCase(reversed)) {
            return "YES";
        }
        return "NO";
    }
}
