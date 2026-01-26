package com.leetcode.javaalgorithms.q1_TwoSum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 이중 loop이므로 시간복잡도가 O(n^2)이 됨
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSum2(int[] nums, int target) {
        // HashMap을 이용한 풀이 : 시간복잡도 O(n)
        // 배열을 한번만 순회하며 target - 현재값 = 필요한 짝을 찾는다.
        // 한 번 본 값은 Map에 저장하여 필요한 짝을 찾을 때 O(1)로 찾을 수 있음
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
