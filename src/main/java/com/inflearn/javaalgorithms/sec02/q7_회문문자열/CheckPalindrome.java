package com.inflearn.javaalgorithms.sec02.q7_회문문자열;

import java.util.Scanner;

public class CheckPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        CheckPalindrome checkPalindrome = new CheckPalindrome();
        System.out.println(checkPalindrome.solution2(s));
    }

    public String solution(String s) {
        s = s.toLowerCase();
        char[] chars = s.toCharArray();
        int lt = 0, rt = chars.length - 1;
        while (lt < rt) {
            if (chars[lt] != chars[rt]) {
                return "NO";
            }
            lt++;
            rt--;
        }
        return "YES";
    }

    public String solution2(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        if (s.equalsIgnoreCase(reversed)) {
            return "YES";
        }
        return "NO";
    }
}
