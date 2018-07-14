// 1- Start with middle number: is it bigger or smaller than our target number?
// 2- We can "rule out" the whole half of the array that we know doesn't
// contain the target number.
// 3- Repeat the same approach (of starting in the middle) on the new half-size
// problem. We either find the number or "rule out" the whole set.

class _12_Find_in_Ordered_Set {
    public static boolean binarySearch(int target, int[] nums) {
        // Start "to the left" of the 0th index
        int lIdx = -1;
        int rIdx = nums.length;

        while (lIdx + 1 < rIdx) {
            int distance = rIdx - lIdx;
            int mid = distance / 2;
            int guessIndex = lIdx + mid;

            int guessValue = nums[guessIndex];
            if (guessValue == target) {
                return true;
            }

            if (guessValue > target) {
                rIdx = guessIndex;
            } else {
                lIdx = guessIndex;
            }
        }

        return false;
    }
}
// A BS algorithm finds an item in a sorted array in O(lgn) time.