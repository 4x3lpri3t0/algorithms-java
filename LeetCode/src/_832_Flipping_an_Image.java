import java.io.*;
import java.util.*;

public class _832_Flipping_an_Image {
    public int[][] flipAndInvertImage(int[][] A) {
        int len = A[0].length;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < (len + 1) / 2; j++) {
                int temp = A[i][j];
                int lastIdx = len - 1 - j;

                // Revert + Invert
                A[i][j] = A[i][len - 1 - j] ^ 1;
                A[i][len - 1 - j] = temp ^ 1;
            }
        }

        return A;
    }
}