import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/majority-element

class _169_Majority_Element {
    private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            } else {
                counts.put(num, counts.get(num) + 1);
            }
        }

        return counts;
    }

    public int majorityElement_HashMap(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);

        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }

        return majorityEntry.getKey();
    }
    // Time complexity : O(n)
    // Because we iterate over nums once and make a constant time HashMap
    // insertion on each iteration.
    //
    // Space complexity : O(n)

    public int majorityElement_Sorting(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
    // Time complexity : O(n log(n))
    //
    // Sorting the array costs O(n log(n)) Java [Dual-pivot Quicksort],
    // so it dominates the overall runtime.
    //
    // Space complexity : O(1) or O(n)
    //
    // We sorted nums in place here - if that is not allowed,
    // then we must spend linear additional space on a copy of nums and
    // sort the copy instead (O(n))

    public int majorityElement_Boyer_Moore_Voting(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
    //    Time complexity : O(n)
    //
    //    Boyer-Moore performs constant work exactly n times,
    //    so the algorithm runs in linear time.
    //
    //    Space complexity : O(1)
    //
    //    Boyer-Moore allocates only constant additional memory.
}