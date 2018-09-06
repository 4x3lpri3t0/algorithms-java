package DP;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class GameScoring {
    static int scoringOptions(int n) {
        if (n <= 0)
            return 0;

        int[] result = new int[n + 1];
        result[0] = 1;
        scoringOptionsRec(n, result);

        return result[n];
    }

    private static int scoringOptionsRec(int n, int[] result) {
        if (n < 0)
            return 0;

        if (result[n] > 0)
            return result[n];

        // Memoize
        result[n] = scoringOptionsRec(n - 1, result) +
                scoringOptionsRec(n - 2, result) +
                scoringOptionsRec(n - 4, result);

        return result[n];
    }

    static int scoringOptionsDp(int n) {
        if (n <= 0)
            return 0;

        // Max score is 4. Hence we need to save the last 4 ways
        // to calculate the number of ways for a given n
        int[] result = new int[4];

        // Save base case on last index of vector
        result[3] = 1;

        for (int i = 0; i < n; i++) {
            int sum = result[3] + result[2] + result[0];

            // Slide left all the results in each iteration
            // Result for current i will be saved at last index
            result[0] = result[1];
            result[1] = result[2];
            result[2] = result[3];
            result[3] = sum;
        }

        return result[3];
    }

    public static void main(String[] args) {
        out.println( "Scoring_Options(4): "+ scoringOptions(4)); //6
        out.println( "Scoring_Options(5): "+ scoringOptions(5)); //10

        out.println( "Scoring_Options(4): "+ scoringOptionsDp(4)); //6
        out.println( "Scoring_Options(5): "+ scoringOptionsDp(5)); //10
    }
}