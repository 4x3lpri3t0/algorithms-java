import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class _9_2_PossiblePaths {
    private static int getPaths(int x, int y) {
        int[][] grid = new int[x][y];

        grid[0][0] = 1;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (i > 0)
                    grid[i][j] += grid[i - 1][j];
                if (j > 0)
                    grid[i][j] += grid[i][j - 1];
            }
        }

        return grid[x - 1][y - 1];
    }

    public static void main(String[] args) {
        // x = 3, y = 3
        // 1  1  1
        // 1  2  3
        // 1  3  6

        // x = 4, y = 4
        // 1  1  1  1
        // 1  2  3  4
        // 1  3  6  10
        // 1  4  10 20

        out.println(getPaths(3,3));
        out.println(getPaths(4,4));
    }


}