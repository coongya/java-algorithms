package com.inflearn.javaalgorithms.sec02.q11_문자열압축;

import java.util.Scanner;

public class RunLengthEncoding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        RunLengthEncoding runLengthEncoding = new RunLengthEncoding();
        System.out.println(runLengthEncoding.solution(s));
    }

    public String solution(String s) {
        // 마지막 문자 비교를 위해 공백 추가
        s = s + " ";
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                count++;
            } else {
                sb.append(s.charAt(i));
                if (count > 1) {
                    sb.append(count);
                }
                count = 1;
            }
        }
        return sb.toString();
    }
}
