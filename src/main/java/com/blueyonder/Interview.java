package com.blueyonder;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Interview {

    static void main() {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        Map<Character, Long> characterFrequency = str.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(characterFrequency);

        //Convert 2D Matrix
        int[][] mat = {
                {1, 2, 3},    // 3 6 9
                {4, 5, 6},  // 2 5 8
                {7, 8, 9}   // 1 4 7
        };

        int[][] result = new int[3][3];

        int rows = mat.length;
        int cols = mat[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[rows - j - 1][i] = mat[i][j];
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
