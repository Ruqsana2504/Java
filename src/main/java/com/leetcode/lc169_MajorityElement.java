package com.leetcode;

import java.util.HashMap;

public class lc169_MajorityElement {

    public static void majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int num : nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        for (int key : map.keySet()) {
            if (map.get(key) > n / 3)
                System.out.println(key);
        }
    }

    static void main() {
        int[] nums = {1, 3, 2, 3, 1, 3, 1, 4, 1, 5, 3};
        majorityElement(nums);
    }
}
