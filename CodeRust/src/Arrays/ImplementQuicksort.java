package Arrays;

import static java.lang.System.out;

// https://www.educative.io/collection/page/5642554087309312/5679846214598656/190003
public class ImplementQuicksort {
    static int partition(int[] arr, int low, int high) {
        int pivotValue = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (i <= high && arr[i] <= pivotValue)
                i++;
            while (arr[j] > pivotValue)
                j--;

            if (i < j) {
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        arr[low] = arr[j];
        arr[j] = pivotValue;

        // Return the pivot index
        return j;
    }

    static void quickSortRec(int[] arr, int low, int high) {
        if (high > low) {
            int pivotIndex = partition(arr, low, high);

            quickSortRec(arr, low, pivotIndex - 1);
            quickSortRec(arr, pivotIndex + 1, high);
        }
    }

    static void quickSort(int[] arr) {
        quickSortRec(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] a = new int[]{33, 6, 21, 12, 19, 29, 38, 22, 14, 40};
        for (int i : a) {
            out.print(i + ", ");
        }
        out.println();

        quickSort(a);

        out.println();
        for (int i : a) {
            out.print(i + ", ");
        }
        out.println();
    }
}
