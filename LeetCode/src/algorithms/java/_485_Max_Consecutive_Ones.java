import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class _485_Max_Consecutive_Ones {

    // Without using conditional expression
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            count *= nums[i];
            max = Math.max(count, max);
        }
        return max;
    }
}