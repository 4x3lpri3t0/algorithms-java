package DP;

public class MaxSumSubsequence {
    static int find_max_sum_nonadjacent(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }

        if (a.length == 1) {
            return a[0];
        }

        int[] result = new int[a.length];
        result[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            // result[i] = 0 or more
            result[i] = Math.max(a[i], result[i - 1]);

            if (i - 2 >= 0) {
                result[i] = Math.max(result[i], a[i] + result[i - 2]);
            }
        }

        return result[a.length - 1];
    }

    public static void main(String[] args) {
        int[] v1 = new int[]{1, 6, 10, 14, 50, -20, -5, -10};
        System.out.println("Max non adjacent sum: " + find_max_sum_nonadjacent(v1));
    }
}