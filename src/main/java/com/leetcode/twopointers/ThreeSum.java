package com.leetcode.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    static void main() {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        Arrays.sort(nums); // -4, -1, -1, 0, 1, 2

        for (int i = 0; i < n - 2; i++) {
            int target = nums[i];
            int low = i + 1;
            int high = n - 1;
            while (low < high) {
                if (nums[low] + nums[high] == (-1 * target)) {
                    temp.add(nums[low]);
                    temp.add(nums[high]);
                    temp.add(target);
                    break;
                } else if (nums[low] + nums[high] > (-1 * target)) {
                    low++;
                } else {
                    high--;
                }
            }
            if (!temp.isEmpty()) {
                result.add(temp);
            }
        }
        return result;
    }
}
