/*
Given an array of integers arr, write a function that returns another array
at the same length where the value at each index i is the product of all array values except arr[i].

Solve without using division and analyze the runtime and space complexity

    Example: given the array [2,  7,  3,  4]
your function would return: [84, 24, 56, 42]
    (by calculating: [7*3*4, 2*3*4, 2*7*4, 2*7*3])
 */

public class Array_of_Array_Products {
    private static int[] getAoAP(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        int n = arr.length;
        int[] result = new int[n];
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = arr[i - 1] * result[i - 1];
        }
        int product = 1;
        for (int i = n - 2; i >= 0; i--) {
            product *= arr[i + 1];
            result[i] *= product;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        arr = getAoAP(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}