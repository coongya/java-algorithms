package com.inflearn.javaalgorithms.sec05.q1_학급회장;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountVotes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        CountVotes countVotes = new CountVotes();
        System.out.println(countVotes.solution(n, s));
    }

    public char solution(int n, String s) {
        char answer = ' ';
        Map<Character, Integer> map = new HashMap<>();
        for (char key : s.toCharArray()) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        for (char key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }
        return answer;
    }
}
