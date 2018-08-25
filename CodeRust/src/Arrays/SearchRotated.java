package Arrays;

import static java.lang.System.*;

public class SearchRotated {
    private static int[] arr;
    private static int val;

    static int binarySearch(int lo, int hi) {
        // Assuming all the keys are unique

        if (lo > hi)
            return -1;

        int mid = (hi + lo) / 2;
        if (arr[mid] == val) {
            return mid;
        }

        if (arr[lo] < arr[mid] && val < arr[mid] && val >= arr[lo]) {

            return binarySearch(lo, mid - 1);

        } else if (arr[mid] < arr[hi] && val > arr[mid] && val <= arr[hi]) {

            return binarySearch(mid + 1, hi);

        } else if (arr[lo] > arr[mid]) {

            return binarySearch(lo, mid - 1);

        } else if (arr[hi] < arr[mid]) {

            return binarySearch(mid + 1, hi);

        }

        return -1;
    }

    static int binarySearchRotated(int[] arr, int key) {
        SearchRotated.arr = arr;
        SearchRotated.val = key;
        return binarySearch(0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] v1 = {6, 7, 1, 2, 3, 4, 5};
        out.println("Key(3) found at: " + binarySearchRotated(v1, 3));
        out.println("Key(6) found at: " + binarySearchRotated(v1, 6));
        int[] v2 = {4, 5, 6, 1, 2, 3};
        out.println("Key(3) found at: " + binarySearchRotated(v2, 3));
        out.println("Key(6) found at: " + binarySearchRotated(v2, 6));
    }
}
