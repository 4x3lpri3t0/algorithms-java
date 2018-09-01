package DPBook._03_SquareSubmatrix;

import static java.lang.Math.*;
import static java.lang.System.*;

public class _02_AnalyzeSubproblems {
    // Top down DP solution. Cache the values to avoid repeating computations
    static int squareSubmatrix(boolean[][] arr) {
        // Don't need to initialize to -1 because only cells that will
        // be 0 are ones that are false and we want to skip those anyway
        int[][] cache = new int[arr.length][arr[0].length];

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j])
                    max = max(max, squareSubmatrix(arr, i, j, cache));
            }
        }

        return max;
    }

    // Overloaded recursive function
    static int squareSubmatrix(boolean[][] arr, int i, int j, int[][] cache) {
        if (i == arr.length || j == arr[0].length)
            return 0;

        if (!arr[i][j])
            return 0;

        // If the value is set in the cache return it
        if (cache[i][j] > 0)
            return cache[i][j];

        // Otherwise compute and save to cache
        cache[i][j] = 1 + min(min(
                squareSubmatrix(arr, i + 1, j, cache),
                squareSubmatrix(arr, i, j + 1, cache)),
                squareSubmatrix(arr, i + 1, j + 1, cache));

        return cache[i][j];
    }

    public static void main(String[] args) {
        boolean[][] arr = {
                {false, true, false, false},
                {true, true, true, true},
                {false, true, true, false}
        };

        out.println(squareSubmatrix(arr));
    }
}
