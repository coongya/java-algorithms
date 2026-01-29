package com.leetcode.javaalgorithms.q26_RemoveDuplicatesfromSortedArray;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates(new int[] {-3,-1,0,0,0,3,3}));;
    }

    public int removeDuplicates(int[] nums) {
        // 중복 제거하려고 Set 생성 : 공간 복잡도 O(n)
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int i = 0;
        // Set을 다시 sorted()로 정렬하면서 시간 복잡도가 O(nlogn)이 됨
        for (Integer num : set.stream().sorted().toList()) {
            nums[i] = num;
            i++;
        }
        return set.size();
    }

    // Two Pointers 풀이
    // 시간 복잡도 : O(n) 배열 순회
    // 공간 복잡도 : O(1) 입력 크기와 무관하게 고정된 변수 lt, rt 두 개만 사용
    // In-place : 추가 공간 없이 입력 데이터를 직접 수정하는 방식, 즉, 새 배열이나 컬렉션을 생성하지 않고 입력으로 들어온 배열 내 swap으로 풀이함
    public int removeDuplicates2(int[] nums) {
        int lt = 0;
        for (int rt = 1; rt < nums.length; rt++) {
            if (nums[lt] != nums[rt]) {
                lt++;
                nums[lt] = nums[rt];
            }
        }
        return lt+1;
    }
}
