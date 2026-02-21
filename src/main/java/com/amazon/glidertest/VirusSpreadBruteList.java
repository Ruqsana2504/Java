package com.amazon.glidertest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VirusSpreadBruteList {

    static void main() {
//        2 1 1    2 0 1
//        1 1 0    1 1 0

        List<List<Integer>> grid = new ArrayList<>();

        grid.add(Arrays.asList(2, 1, 1));
        grid.add(Arrays.asList(1, 1, 0));

//        grid.add(Arrays.asList(2, 0, 1));
//        grid.add(Arrays.asList(1, 1, 0));

        System.out.println(minTimeToInfect(grid));
    }

    public static int minTimeToInfect(List<List<Integer>> grid) {
        int n = grid.size();
        int m = grid.getFirst().size();

        int healthy = 0;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid.get(i).get(j) == 1)
                    healthy++;

        if (healthy == 0) return 0;

        int time = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (true) {

            boolean infected = false;

            List<List<Integer>> temp = new ArrayList<>();
            for (int i = 0; i < n; i++)
                temp.add(new ArrayList<>(grid.get(i)));

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {

                    if (grid.get(i).get(j) == 2) {

                        for (int[] d : dirs) {
                            int ni = i + d[0];
                            int nj = j + d[1];

                            if (ni >= 0 && ni < n &&
                                    nj >= 0 && nj < m &&
                                    grid.get(ni).get(nj) == 1 &&
                                    temp.get(ni).get(nj) == 1) {

                                temp.get(ni).set(nj, 2);
                                healthy--;
                                infected = true;
                            }
                        }
                    }
                }
            }

            if (!infected) break;

            grid = temp;
            time++;
        }

        return healthy == 0 ? time : -1;
    }
}