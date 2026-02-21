package com.epam;

import java.util.Arrays;

class ShiftPositiveNegative {
    static void main() {
        int[] arr = {1, 3, -3, 8, -2, -4, 9, 5, -1};
        int positiveIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                int temp = arr[i];
                int j = i;

                // Shift negatives to right
                while (j > positiveIndex) {
                    arr[j] = arr[j - 1];
                    j--;
                }

                arr[positiveIndex] = temp;
                positiveIndex++;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}