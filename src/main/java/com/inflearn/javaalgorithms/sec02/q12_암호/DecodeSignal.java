package com.inflearn.javaalgorithms.sec02.q12_암호;

import java.util.Scanner;

public class DecodeSignal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.next();
        DecodeSignal decodeSignal = new DecodeSignal();
        System.out.println(decodeSignal.solution(n, s));
    }

    public String solution(int n, String s) {
        String answer = "";
        for (int i = 0; i < n; i++) {
            String temp = s.substring(i*7, (i+1)*7).replace('#','1').replace('*','0');
            int number = Integer.parseInt(temp, 2);
            answer += (char)number;
        }
        return answer;
    }
}
