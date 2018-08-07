import java.util.*;

import static java.lang.System.out;

public class _9_3_MagicIndex {
    // Binary Search
    static int magic(int[] array, int start, int end) {
        if (end < start || start < 0 || end >= array.length) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (array[mid] == mid) {
            return mid;
        } else if (array[mid] > mid) {
            return magic(array, start, mid - 1);
        } else {
            return magic(array, mid + 1, end);
        }
    }

    static int magic(int[] array) {
        return magic(array, 0, array.length - 1);
    }

    // Creates an array that is distinct and sorted
    static int[] getDistinctSortedArray(int size) {
        int[] array = AssortedMethods.randomArray(size, -1 * size, size);
        Arrays.sort(array);
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1]) {
                array[i]++;
            } else if (array[i] < array[i - 1]) {
                array[i] = array[i - 1] + 1;
            }
        }

        return array;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int size = AssortedMethods.randomIntInRange(5, 20);
            int[] array = getDistinctSortedArray(size);

            for (int j = 0; j < array.length; j++) {
                out.print("i = " + j + ", v = " + array[j] + ". ");
            }
            out.println();
            out.println("Result: " + magic(array));
        }
    }

    // Follow up (What if the values are not distinct?)
    public static int magicB(int[] array, int start, int end) {
        if (end < start || start < 0 || end >= array.length) {
            return -1;
        }
        int midIndex = (start + end) / 2;
        int midValue = array[midIndex];
        if (midValue == midIndex) {
            return midIndex;
        }
        /* Search left */
        int leftIndex = Math.min(midIndex - 1, midValue);
        int left = magicB(array, start, leftIndex);
        if (left >= 0) {
            return left;
        }

        /* Search right */
        int rightIndex = Math.max(midIndex + 1, midValue);
        int right = magicB(array, rightIndex, end);

        return right;
    }
}