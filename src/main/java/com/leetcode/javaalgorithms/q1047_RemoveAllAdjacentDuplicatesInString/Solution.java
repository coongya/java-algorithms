package com.leetcode.javaalgorithms.q1047_RemoveAllAdjacentDuplicatesInString;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates2("abbaca"));    // "ca"
        System.out.println(solution.removeDuplicates2("azxxzy"));    // "ay"
        System.out.println(solution.removeDuplicates2("aababaab"));  // "ba"
    }

    // 풀이 1: loop
    // 시간복잡도 O(n^2), 공간복잡도 O(n)
    // 문자열을 순회하다가 인접한 중복 문자를 발견하면 제거하고 문자열과 인덱스를 리셋해서 다시 처음부터 순회하는 방식
    public String removeDuplicates(String s) {
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                s = s.substring(0, i) + s.substring(i+2);
                i = -1;
            }
        }
        return s;
    }

    // 풀이 2: StringBuilder를 스택처럼 활용
    // 시간복잡도 O(n), 공간복잡도 O(n)
    // StringBuilder를 stack처럼 활용해서 매번 새 문자열을 리셋할 필요없이 스택의 마지막 문자와 새로 들어올 문자가 같으면 둘다 제거하는 과정을 통해 한 번의 순회로 인접 문자 중복 제거가 가능함.
    public String removeDuplicates2(String s) {
        StringBuilder stack = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (stack.length() > 0 && stack.charAt(stack.length() - 1) == c) {
                stack.deleteCharAt(stack.length() - 1);
            } else {
                stack.append(c);
            }
        }
        return stack.toString();
    }
}
