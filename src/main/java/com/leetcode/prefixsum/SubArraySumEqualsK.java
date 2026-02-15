package com.leetcode.prefixsum;

import java.util.HashMap;

public class SubArraySumEqualsK {
    static void main() {
        int[] nums = {1, 1, 1};
        int k = 2;
        int result = subarraySum(nums, k);
        System.out.println(result); // Output: 2
    }

    public static int subarraySum(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (freq.containsKey(sum - k)) {
                count += freq.get(sum - k);
            }
            freq.put(sum, freq.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
