package Arrays;

import static java.lang.System.out;

// https://www.educative.io/collection/page/5642554087309312/5679846214598656/240002
public class BinarySearch {
    static int binarySearchIterative(int[] A, int key) {
        int lo = 0;
        int hi = A.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (A[mid] == key)
                return mid;

            if (key < A[mid])
                hi = mid - 1;
            else
                lo = mid + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 7, 8, 12, 15, 19, 24, 50, 69, 80, 100};
        out.println("Key(12) found at: " + binarySearchIterative(arr1, 12));
        out.println("Key(44) found at: " + binarySearchIterative(arr1, 44));
        out.println("Key(80) found at: " + binarySearchIterative(arr1, 80));
    }
}
