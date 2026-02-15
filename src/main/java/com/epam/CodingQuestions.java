package com.epam;

import com.Util;

import java.util.Arrays;
import java.util.List;

public class CodingQuestions {

    static void main() {
        System.out.println(validInteger(List.of("aaa", "123", "a456", "789")));
        int[] arr = new int[]{0, 1, 0, 0, 3, 12};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static List<Integer> validInteger(List<String> list) {
        return list.stream()
                .filter(str -> str.chars().allMatch(Character::isDigit))
                .map(Integer::valueOf)
                .toList();
    }

    //Move zeroes to the end of the array
    public static void moveZeroes(int[] nums) {
        int zeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                Util.swap(nums, i, zeroIndex);
                zeroIndex++;
            }
        }
    }
}