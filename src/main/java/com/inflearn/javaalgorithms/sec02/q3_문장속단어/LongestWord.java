package com.inflearn.javaalgorithms.sec02.q3_문장속단어;

import java.util.Scanner;

public class LongestWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        LongestWord main = new LongestWord();
        System.out.println(main.solution2(input));
    }

    public String solution(String input) {
        int maxLength = 0;
        String longestWord = "";
        String[] strings = input.split(" ");
        for (String string : strings) {
            if (string.length() > maxLength) {
                maxLength = string.length();
                longestWord = string;
            }
        }
        return longestWord;
    }

    public String solution2(String input) {
        int maxLength = 0;
        String longestWord = "";
        int index = 0;
        while((index = input.indexOf(" ")) != -1) {
            String temp = input.substring(0, index);
            input = input.substring(index + 1);
            if (temp.length() > maxLength) {
                maxLength = temp.length();
                longestWord = temp;
            }
        }
        // 마지막 단어 길이도 비교해야 함
        if (input.length() > maxLength) {
            return input;
        }
        return longestWord;
    }
}
