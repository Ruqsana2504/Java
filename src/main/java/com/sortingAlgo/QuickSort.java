package com.sortingAlgo;

import java.util.Arrays;

import static com.Util.swap;

public class QuickSort {

    static void main() {
        int[] arr = {10, 7, 8, 9, 1, 5};
        quickSorting(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSorting(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSorting(arr, low, pivot - 1);
            quickSorting(arr, pivot + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;
        int j = high - 1;
        while (i < j) {
            while (i < high && arr[i] <= pivot) {
                i++;
            }

            while (j >= low && arr[j] > pivot) {
                j--;
            }

            if (i < j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        swap(arr, i, high);
        return i;
    }
}
