package com.leetcode;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int n = height.length;
        int count = 0;
        int[] leftSuffix = new int[n];
        int[] rightSuffix = new int[n];

        leftSuffix[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftSuffix[i] = Math.max(leftSuffix[i - 1], height[i]);
        }

        rightSuffix[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightSuffix[i] = Math.max(rightSuffix[i + 1], height[i]);
        }

        for (int i = 0; i < n; i++) {
            // Update the maximum water
            count += Math.min(leftSuffix[i], rightSuffix[i]) - height[i];
        }
        return count;
    }
}