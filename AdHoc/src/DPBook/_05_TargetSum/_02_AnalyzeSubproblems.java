package DPBook._05_TargetSum;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.*;
import static java.lang.System.*;

public class _02_AnalyzeSubproblems {
    static int[] nums;
    static int T;

    // Top down DP solution. Like 0-1 Knapsack, use HashMap to save space.
    static int targetSum(int[] numbers, int target) {
        nums = numbers;
        T = target;

        // Map: i -> sum -> value
        Map<Integer, Map<Integer, Integer>> cache = new HashMap<>();

        return targetSum(0, 0, cache);
    }

    private static int targetSum(int i, int sum,
            Map<Integer, Map<Integer, Integer>> cache) {
        if (i == nums.length)
            return sum == T ? 1 : 0;

        // Check cache and return if we get a hit
        if (!cache.containsKey(i))
            cache.put(i, new HashMap<>());

        Integer cached = cache.get(i).get(sum);

        if (cached != null)
            return cached;

        // Compute value and store in cache
        int toReturn =
                targetSum(i + 1, sum + nums[i], cache) +
                targetSum(i + 1, sum - nums[i], cache);

        cache.get(i).put(sum, toReturn);

        return toReturn;
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
