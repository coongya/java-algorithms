package com.inflearn.javaalgorithms.sec06.q2_괄호문자제거;

import java.util.Scanner;
import java.util.Stack;

public class RemoveParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        RemoveParentheses removeParentheses = new RemoveParentheses();
        System.out.println(removeParentheses.solution(s));
    }

    public String solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ')') {
                while (stack.pop() != '(') {
                }
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
