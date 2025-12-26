package com.inflearn.javaalgorithms.sec02.q1;

import java.util.Scanner;

public class FindChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.nextLine();
        char input2 = scanner.nextLine().charAt(0);

        FindChar findChar = new FindChar();
        System.out.println(findChar.solution(input1, input2));
    }

    public int solution(String s, char c) {
        int answer = 0;
        s = s.toLowerCase();
        c = Character.toLowerCase(c);
        for (char ch : s.toCharArray()) {
           if (ch == c) {
               answer++;
           }
        }

        return answer;
    }
}
