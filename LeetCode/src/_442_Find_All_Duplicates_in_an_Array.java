import java.io.*;
import java.util.*;

public class _442_Find_All_Duplicates_in_an_Array {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length <= 1)
            return result;

        int i = 0;
        while (i < nums.length) {
            int idx = nums[i] - 1;
            if (nums[idx] == nums[i]) {
                i++;
            } else { // Swap
                int temp = nums[idx];
                nums[idx] = nums[i];
                nums[i] = temp;
            }
        }

        // Number is different than its index
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1)
                result.add(nums[j]);
        }

        return result;
    }
}