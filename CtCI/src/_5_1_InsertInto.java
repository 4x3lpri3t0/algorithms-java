import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class _5_1_InsertInto {
    public static int updateBits(int n, int m, int i, int j) {
        // Validation
        if (i >= 32 || j < i)
            return 0;

        // Create a mask to clear bits i through j in n
		// EXAMPLE: i = 2, j = 4. Result should be 11100011.
        // (Using 8 bits for this example. This is not actually 8 bits.)
        int allOnes = ~0; // allOnes = 11111111

        // 1s through position j, then 0s. left = 11100000
        int left = allOnes << (j + 1);

        // 1s after position i. right = 00000011
        int right = ((1 << i) - 1);

        // All 1s, except for 0s between i and j. mask = 11100011
        int mask = left | right;

        // Clear i through j, then put m in there
        int nCleared = n & mask; // Clear bits j through i.
        int mShifted = m << i; // Move m into correct position.

        // OR them
        return nCleared | mShifted;
    }

    public static void main(String[] args) {
        int a = 103217;
        out.println(AssortedMethods.toFullBinaryString(a));

        int b = 13;
        out.println(AssortedMethods.toFullBinaryString(b));

        int c = updateBits(a, b, 4, 12);
        out.println(AssortedMethods.toFullBinaryString(c));
    }
}