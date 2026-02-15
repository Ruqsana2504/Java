package com.mphasis;

import com.Util;

import java.util.Arrays;

public class MoveZeroesToEnd {

//    static void main() {
//        int[] arr = {1, 0, 2, 0, 0, 1, 3, 0, 4, 5, 0, 0};
//        int n = arr.length;
//        int end = n - 1;
//
//        // Step 1: Move non-zeros to the end (backwards) maintaining order
//        for (int i = n - 1; i >= 0; i--) {
//            if (arr[i] != 0) {
//                arr[end--] = arr[i];
//            }
//        }
//
//        // Step 2: Fill the beginning with zeros
//        while (end >= 0) {
//            arr[end--] = 0;
//        }
//
//
//        System.out.println("Array after moving non-zero elements to the end: " + Arrays.toString(arr));
//    }

    static void main() {

//        Input:  [0, 1, 0, 3, 12]
//        Output: [1, 3, 12, 0, 0]
        int[] arr = {0, 1, 0, 3, 12};
        int n = arr.length;
        moveToEnd(arr, n);
        System.out.println(Arrays.toString(arr));
    }

    private static void moveToEnd(int[] arr, int n) {
        int i = 0;
        int j = 0;
        while (j < n) {
            if (arr[j] != 0) {
                Util.swap(arr, i, j);
                i++;
            }
            j++;
        }
    }

}