package DPBook._05_TargetSum;

import static java.lang.Math.*;
import static java.lang.System.*;

public class _01_First {
    // Naive brute force solution. Find every combo.
    static int targetSum(int[] nums, int T) {
        return targetSum(nums, T, 0, 0);
    }

    // Overloaded recursive function
    static int targetSum(int[] nums, int T, int i, int sum) {
        // When we've gone through every item,
        // see if we've reached our target sum
        if (i == nums.length)
            return sum == T ? 1 : 0;

        // Combine the possibilities by adding and subtracting current value
        return targetSum(nums, T, i + 1, sum + nums[i])
                + targetSum(nums, T, i + 1, sum - nums[i]);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int T = 3;

        /*
        1 + 1 + 1 + 1 - 1
        1 + 1 + 1 - 1 + 1
        1 + 1 - 1 + 1 + 1
        1 - 1 + 1 + 1 + 1
        -1 + 1 + 1 + 1 + 1
        */

        out.println(targetSum(nums, T)); // 5
    }
}