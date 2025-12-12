package com.interview;

import java.util.Arrays;

public class Interview {

    static void main() {
        int[] arr = {1, 0, 2, 0, 0, 1, 3, 0, 4, 5, 0, 0};
        int n = arr.length;
        int end = n - 1;

        // Step 1: Move non-zeros to the end (backwards) maintaining order
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] != 0) {
                arr[end--] = arr[i];
            }
        }

        // Step 2: Fill the beginning with zeros
        while (end >= 0) {
            arr[end--] = 0;
        }


        System.out.println("Array after moving non-zero elements to the end: " + Arrays.toString(arr));
    }
}
