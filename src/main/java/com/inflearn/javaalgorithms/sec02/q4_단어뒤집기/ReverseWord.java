package com.inflearn.javaalgorithms.sec02.q4_단어뒤집기;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ReverseWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        scanner.nextLine();
        String[] strings = new String[i];
        for (int j = 0; j < i; j++) {
            strings[j] = scanner.nextLine();
        }
        ReverseWord main = new ReverseWord();
        for (String string : strings) {
            System.out.println(main.solution4(string));
        }
    }

    public String solution(String input) {
        StringBuilder answer = new StringBuilder();
        for (int j = input.length() - 1; j >= 0; j--) {
            answer.append(input.charAt(j));
        }
        return answer.toString();
    }

    // Stack의 LIFO(Last In, First Out)를 적용하고자 했으나 Java에서는 Stack 대신 Deque 구현체 사용이 권장됨
    // 이유 : Stack은 Vector를 상속받아 LIFO 원칙을 위반할 수 있는 메서드가 노출되는 설계상의 문제가 있음(예: get() 인덱스 접근, add()로 중간 삽입 등)
    public String solution2(String input) {
        StringBuilder answer = new StringBuilder();
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : input.toCharArray()) {
            deque.push(c);
        }
        while (!deque.isEmpty()) {
            answer.append(deque.pop());
        }
        return answer.toString();
    }

    // 내부적으로는 Two Pointer와 동일한 로직이라고 함..
    public String solution3(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    // Two Pointer
    public String solution4(String input) {
        char[] charArray = input.toCharArray();
        int lt = 0, rt = charArray.length - 1;
        while (lt < rt) {
            char temp = charArray[lt];
            charArray[lt] = charArray[rt];
            charArray[rt] = temp;
            lt++;
            rt--;
        }
        return String.valueOf(charArray);
    }
}
