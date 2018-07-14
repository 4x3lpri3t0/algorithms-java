// https://leetcode.com/problems/maximum-subarray/

class _53_Maximum_Subarray {
    public int maxSubArray(int[] A) {
        int res = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < A.length; i++) {
            sum = Math.max(sum, 0) + A[i];
            res = Math.max(res, sum);
        }

        return res;
    }
}

// DP solution: Check previous sum
// O(n) time
// O(1) space