// https://leetcode.com/problems/move-zeroes

class _283_Move_Zeroes {
    public void moveZeroes(int[] nums) {
        int lastNonZeroFoundAt = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (temp != 0) {
                nums[i] = nums[lastNonZeroFoundAt];
                nums[lastNonZeroFoundAt] = temp;
                lastNonZeroFoundAt++;
            }
        }
    }
}

// Time complexity: O(n)
// Space complexity: O(1). Only constant space is used.