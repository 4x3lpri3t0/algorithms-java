package Arrays;

import java.util.*;

import static java.lang.System.out;

// Two pointers
public class MoveZeroesToLeft {
    static void moveZerosToLeft(int[] A) {
        if (A == null) {
            return;
        }

        int writeIndex = A.length - 1;
        int readIndex = A.length - 1;

        while (readIndex >= 0) {
            if (A[readIndex] != 0) {
                A[writeIndex] = A[readIndex];
                writeIndex--;
            }

            readIndex--;
        }

        while (writeIndex >= 0) {
            A[writeIndex] = 0;
            writeIndex--;
        }
    }

    public static void main(String[] args) {
        int[] v = new int[]{1, 10, -1, 11, 5, 0, -7, 0, 25, -35};
        out.println("Original Array: " + Arrays.toString(v));
        moveZerosToLeft(v);
        for (int i = 0; i < v.length; i++) {
            out.print(v[i] + ", ");
        }
    }
}