package com.wissentech;

// You are given a 2D grid consisting of 0s and 1s, where 1 represents land and 0 represents water. An island is formed by a group of connected 1s. A cell is connected to another cell only if it is adjacent horizontally or vertically (top, bottom, left, or right). Diagonal connections are not allowed. Write a program to find the total number of islands present in the grid.
// Example:
// Input grid:
// 1 1 0 0 0
// 1 1 0 0 1
// 0 0 1 0 1
// 0 0 0 1 1
// Output:
// 3

public class Island {
    static void main() {
        int[][] grid = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 1},
                {0, 0, 1, 0, 1},
                {0, 0, 0, 1, 1}
        };
        System.out.println(countIslands(grid));
    }

    private static boolean countIslands(int[][] grid) {
        return false;
    }
}
