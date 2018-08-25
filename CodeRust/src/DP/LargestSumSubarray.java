package DP;

// https://www.educative.io/collection/page/5642554087309312/5679846214598656/50002
public class LargestSumSubarray {
    static int findMaxSumSubArray(int[] A) {
        if (A.length < 1) {
            return 0;
        }

        int currMax = A[0];
        int globalMax = A[0];
        for (int i = 1; i < A.length; i++) {
            if (currMax < 0) {
                currMax = A[i];
            } else {
                currMax += A[i];
            }

            globalMax = Math.max(currMax, globalMax);
        }

        return globalMax;
    }

    public static void main(String[] args) {
        int[] v = new int[]{1, 10, -1, 11, 5, -30, -7, 20, 25, -35};
        System.out.println("Sum of largest subarray: " + findMaxSumSubArray(v));


        int[] v1 = new int[]{-15, -14, -10, -19, -5, -21, -10};
        System.out.println("Sum of largest subarray: " + findMaxSumSubArray(v1));
    }
}