package Arrays;

import java.util.*;

import static java.lang.System.out;

class RotateArray {
    static void reverse(List<Integer> arr, int start, int end) {
        while (start < end) {
            int temp = arr.get(start);
            arr.set(start, arr.get(end));
            arr.set(end, temp);
            ++start;
            --end;
        }
    }

    static void rotateArrayInPlace(List<Integer> arr, int n) {
        int len = arr.size();
        // Let's normalize rotations
        // if n > array size or n is negative
        n = n % len;
        if (n < 0) {
            // Calculate the positive rotations needed
            n = n + len;
        }

        // Partition the array based on rotations 'n'
        // E.g.: 1, 2, 3, 4, 5 where n = 2
        // -> 5, 4, 3, 2, 1
        // -> 4, 5, 3, 2, 1
        // -> 4, 5, 1, 2, 3

        reverse(arr, 0, len - 1);
        reverse(arr, 0, n - 1);
        reverse(arr, n, len - 1);
    }

    public static void main(String[] args) {
        List<Integer> v1 = Arrays.asList(1, 2, 3, 4, 5);
        out.println("Array Before Rotation " + v1);
        rotateArrayInPlace(v1, 2);
        out.println("Array After Rotation: " + v1);

        List<Integer> v2 = Arrays.asList(1, 2, 3, 4, 5);
        out.println("Array Before Rotation: " + v2);
        rotateArrayInPlace(v2, -3);
        out.println("Array After Rotation: " + v2);
    }
}