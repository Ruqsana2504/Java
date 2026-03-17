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

//        grid = new int[][]{
//                {1, 1, 1, 1, 0},
//                {1, 1, 0, 1, 0},
//                {1, 1, 0, 0, 0},
//                {0, 0, 0, 0, 0}
//        };
        System.out.println(countIslands(grid));
    }

    private static int countIslands(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int noOfIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    noOfIslands++;
                }
            }
        }
        return noOfIslands;
    }

    private static void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }

        grid[i][j] = 0;

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
