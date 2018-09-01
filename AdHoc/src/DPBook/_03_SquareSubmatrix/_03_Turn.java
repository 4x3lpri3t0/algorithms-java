package DPBook._03_SquareSubmatrix;

import static java.lang.Math.*;
import static java.lang.System.*;

public class _03_Turn {
    // Bottom up solution. Start from the upper left corner and
    // compute each larger submatrix.
    static int squareSubmatrix(boolean[][] arr) {
        int max = 0;

        // Init cache
        int[][] cache = new int[arr.length][arr[0].length];

        // Iterate over matrix to compute each value
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[0].length; j++) {
                // If we're in the first row/col then the value is just 1
                // if that cell is true and 0 otherwise.
                // In other rows and cols need to look up and to the left.
                if (i == 0 || j == 0) {
                    cache[i][j] = arr[i][j] ? 1 : 0;
                } else if (arr[i][j]) {
                    cache[i][j] = 1 + min(min(
                            cache[i][j - 1],
                            cache[i - 1][j]),
                            cache[i - 1][j - 1]);
                }

                max = max(max, cache[i][j]);
            }
        }

        return max;
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
