package DPBook._05_TargetSum;

import static java.lang.Math.*;
import static java.lang.System.*;

public class _03_Turn {
    // Bottom up DP solution
    static int targetSum(int[] nums, int T) {
        int sum = 0;

        // Our cache has to range from -sum(nums) to
        // sum(nums), so we offset everything by sum
        for (int num : nums)
            sum += num;

        int[][] cache = new int[nums.length + 1][2 * sum + 1];
        if (sum == 0)
            return 0;

        // Initialize i=0, T=0
        cache[0][sum] = 1;

        // Iterate over previous row and update the current row
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j < 2 * sum + 1; j++) {
                int prev = cache[i - 1][j];
                if (prev != 0) {
                    cache[i][j - nums[i - 1]] += prev;
                    cache[i][j + nums[i - 1]] += prev;
                }
            }
        }

        return cache[nums.length][sum + T];
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
