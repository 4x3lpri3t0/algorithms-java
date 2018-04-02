public class _40_Find_Duplicate_Optimize_for_Space {
    public static int findRepeat(int[] numbers) {
        int floor = 1;
        int ceiling = numbers.length - 1;

        while (floor < ceiling) {
            // Divide our range 1..n into an upper range and lower range
            // (such that they don't overlap)
            // lower range is floor..midpoint
            // upper range is midpoint+1..ceiling
            int midpoint = floor + ((ceiling - floor) / 2);
            int lowerRangeFloor   = floor;
            int upperRangeFloor   = midpoint + 1;
            int upperRangeCeiling = ceiling;

            // Count number of items in lower range
            int itemsInLowerRange = 0;
            for (int num : numbers) {
                // Is it in the lower range?
                if (num >= lowerRangeFloor && num <= midpoint) {
                    itemsInLowerRange += 1;
                }
            }

            int distinctPossibleIntegersInLowerRange = midpoint - lowerRangeFloor + 1;

            if (itemsInLowerRange > distinctPossibleIntegersInLowerRange) {
                // There must be a duplicate in the lower range
                // so use the same approach iteratively on that range
                floor   = lowerRangeFloor;
                ceiling = midpoint;
            } else {
                // There must be a duplicate in the upper range
                // so use the same approach iteratively on that range
                floor   = upperRangeFloor;
                ceiling = upperRangeCeiling;
            }
        }

        // Floor and ceiling have converged
        // we found a number that repeats!
        return floor;
    }
}