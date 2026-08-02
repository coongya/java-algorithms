package com.inflearn.javaalgorithms.sec05.q2_아나그램;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CheckAnagram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        CheckAnagram checkAnagram = new CheckAnagram();
        System.out.println(checkAnagram.solution(s1, s2));
    }

    public String solution(String s1, String s2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        for (char c : s2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        //  HashMap의 키와 값이 모두 같은지 비교
        if (map1.equals(map2)) {
           return "YES";
        }
        return "NO";
    }

    public String solution2(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : s2.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }
        if (map.values().stream().allMatch(x -> x == 0)) {
            return "YES";
        }
        return "NO";
    }
}
