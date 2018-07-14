import java.io.*;
import java.util.*;

public class _868_Transpose_Matrix {
    public int[][] transpose(int[][] A) {
        // Validate input?

        // Assign row.length to transpodedColLen
        int transposedColLen = A.length;

        // Assign col.length to transposedRowLen
        int transposedRowLen = A[0].length;

        // Create new matrix with transposed capacity
        int[][] newMatrix = new int[transposedRowLen][transposedColLen];

        // Loop old matrix, assign i to j and j to i to new matrix for each element
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                newMatrix[j][i] = A[i][j];
            }
        }

        // Return transposed matrix
        return newMatrix;
    }
}