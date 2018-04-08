/*
Given an array of integers arr, write a function that returns another array
at the same length where the value at each index i is the product of all array values except arr[i].

Solve without using division and analyze the runtime and space complexity

    Example: given the array [2,  7,  3,  4]
your function would return: [84, 24, 56, 42]
    (by calculating: [7*3*4, 2*3*4, 2*7*4, 2*7*3])
 */

import java.util.Arrays;

public class Array_of_Array_Products {
    static int[] arrayOfArrayProducts(int[] arr) {
        int n = arr.length;
        if (n == 0 || n == 1) {
            return new int[0];
        }

        int[] result = new int[n];

        // Iterate from left to right
        int accum = 1;
        for (int i = 0; i < arr.length; i++) {
            result[i] = accum;
            accum *= arr[i];
        }

        // Iterate from right to left
        accum = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            result[i] *= accum;
            accum *= arr[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2, 3, 4, 5};
        System.out.println(Arrays.toString(arrayOfArrayProducts(arr)));
        // [60, 40, 30, 24]
    }
}