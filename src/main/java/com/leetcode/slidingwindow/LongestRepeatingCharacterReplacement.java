package com.leetcode.slidingwindow;

public class LongestRepeatingCharacterReplacement {

    static void main() {
        System.out.println(characterReplacement("AABABBA", 1));
    }

    public static int characterReplacement(String s, int k) {
        int low = 0;
        int result_sum = Integer.MIN_VALUE;
        int[] arr = new int[26];

        for (int high = 0; high < s.length(); high++) {
            arr[s.charAt(high) - 'A']++;
            int maxCnt = find(arr);
            int len = high - low + 1;
            int diff = len - maxCnt;

            while (diff > k) {
                arr[s.charAt(low) - 'A']--;
                low++;
                maxCnt = find(arr);
                len = high - low + 1;
                diff = len - maxCnt;
            }

            result_sum = Math.max(result_sum, len);
        }

        return result_sum;
    }

    public static int find(int[] arr) {
        int maxCnt = 0;
        for (int i = 0; i < 26; i++) {
            maxCnt = Math.max(maxCnt, arr[i]);
        }
        return maxCnt;
    }

    public static int characterReplacement1(String s, int k) {
        int[] freq = new int[26];
        int low = 0;
        int result = Integer.MIN_VALUE;
        int maxCount = 0;

        for (int high = 0; high < s.length(); high++) {
            int val = s.charAt(high) - 'A';
            freq[val]++;
            maxCount = Math.max(maxCount, freq[val]);
            int len = high - low + 1;
            int diff = len - maxCount;

            while (diff > k) {
                freq[s.charAt(low) - 'A']--;
                low++;
                maxCount = Math.max(maxCount, freq[s.charAt(low) - 'A']);
                len = high - low + 1;
                diff = len - maxCount;
            }
            result = Math.max(result, len);
        }
        return result;
    }
}

