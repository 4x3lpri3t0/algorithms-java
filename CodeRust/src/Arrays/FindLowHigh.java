package Arrays;

import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

public class FindLowHigh {
    static int findLowIndex(List<Integer> arr, int key) {
        int low = 0;
        int high = arr.size() - 1;
        int mid = high / 2;

        while (low < high) {
            int mid_elem = arr.get(mid);

            if (mid_elem < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

            mid = low + (high - low) / 2;
        }

        if (arr.get(low) == key)
            return low;

        return -1;
    }

    static int findHighIndex(List<Integer> arr, int key) {
        int low = 0;
        int high = arr.size() - 1;
        int mid = high / 2;

        while (low <= high) {
            int mid_elem = arr.get(mid);

            if (mid_elem <= key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

            mid = low + (high - low) / 2;
        }

        if (arr.get(high) == key)
            return high;

        return -1;
    }

    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6);

        int low = findLowIndex(array, 5);
        int high = findHighIndex(array, 5);
        out.println("LowIndex of 5 : " + low);
        out.println("HighIndex of 5 : " + high);

        low = findLowIndex(array, 2);
        high = findHighIndex(array, 2);
        out.println("LowIndex of 2 : " + low);
        out.println("HighIndex of 2 : " + high);
    }
}