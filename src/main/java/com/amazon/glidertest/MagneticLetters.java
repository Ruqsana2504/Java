package com.amazon.glidertest;

import java.util.Scanner;

public class MagneticLetters {

    static void main() {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String r = sc.nextLine();

        String combined = s1 + s2;

        if (combined.length() != r.length()) {
            System.out.println("No");
            return;
        }

        int[] freq = new int[26];

        // Count characters from combined string
        for (char c : combined.toCharArray()) {
            freq[c - 'A']++;
        }

        // Subtract characters from R
        for (char c : r.toCharArray()) {
            freq[c - 'A']--;
        }

        // Check if all frequencies are zero
        for (int count : freq) {
            if (count != 0) {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }
}