package com.inflearn.javaalgorithms.sec05.q4_모든아나그램찾기;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindAllAnagrams {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String t = scanner.next();
        FindAllAnagrams findAllAnagrams = new FindAllAnagrams();
        System.out.println(findAllAnagrams.solution(s, t));
    }

    public int solution(String s, String t) {
        int count = 0;
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        Map<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        if (tMap.equals(sMap)) count++;
        int lt = 0;
        for (int rt = t.length(); rt < s.length(); rt++) {
            sMap.put(s.charAt(rt), sMap.getOrDefault(s.charAt(rt), 0) + 1);
            sMap.put(s.charAt(lt), sMap.get(s.charAt(lt)) - 1);
            if (sMap.get(s.charAt(lt)) == 0) sMap.remove(s.charAt(lt));
            lt++;
            if (tMap.equals(sMap)) count++;
        }
        return count;
    }
}
