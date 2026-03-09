package com.inflearn.javaalgorithms.sec02.q5_특정문자뒤집기;

import java.util.Scanner;

public class ReverseOnlyLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ReverseOnlyLetters reverseOnlyLetters = new ReverseOnlyLetters();
        System.out.println(reverseOnlyLetters.solution(input));
    }

    // Conditional Two Pointer
    // 조건을 만족하지 않는 포인터만 개별 이동한다.
    // if-else if-else 구조로 loop 한 턴에 하나의 분기만 실행되므로 포인터가 서로를 건너뛰는 일이 없다.
    public String solution(String input) {
        int lt = 0, rt = input.length() - 1;
        char[] chars = input.toCharArray();
        while (lt < rt) {
            if (!Character.isAlphabetic(chars[lt])) {
                lt++;
            } else if (!Character.isAlphabetic(chars[rt])) {
                rt--;
            } else {
                char temp = chars[lt];
                chars[lt] = chars[rt];
                chars[rt] = temp;
                lt++;
                rt--;
            }
        }
        return String.valueOf(chars);
    }
}
