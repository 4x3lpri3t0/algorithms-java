import java.io.*;
import java.util.*;

// https://leetcode.com/problems/array-partition-i/

public class _561_Array_Partition_I {
    public int arrayPairSum(int[] nums) {
        // Sort
        Arrays.sort(nums);

        int sum = 0;

        // Get pairs min
        for (int i = 0; i < nums.length - 1; i += 2) {
            sum += Math.min(nums[i], nums[i + 1]);
        }

        // Return sum
        return sum;
    }
}