// At each iteration we're keeping track of and updating:
//
// * highestProductOf3
// * highestProductOf2
// * highest
// * lowestProductOf2
// * lowest

class _03_highest_product_of_3 {
    public static int highestProductOf3(int[] arrayOfInts) {
        if (arrayOfInts.length < 3) {
            throw new IllegalArgumentException("Less than 3 items!");
        }

        // We're going to start at the 3rd item (at index 2)
        // so pre-populate highests and lowests based on the first 2 items.
        int highest = Math.max(arrayOfInts[0], arrayOfInts[1]);
        int lowest = Math.min(arrayOfInts[0], arrayOfInts[1]);

        int highestProductOf2 = arrayOfInts[0] * arrayOfInts[1];
        int lowestProductOf2 = arrayOfInts[0] * arrayOfInts[1];

        // Except this one--we pre-populate it for the first *3* items.
        int highestProductOf3 = arrayOfInts[0] * arrayOfInts[1] * arrayOfInts[2];

        // Walk through items, starting at index 2
        for (int i = 2; i < arrayOfInts.length; i++) {
            int current = arrayOfInts[i];

            // Do we have a new highest product of 3?
            // It's either the current highest,
            // or the current times the highest product of two
            // or the current times the lowest product of two
            highestProductOf3 = Math.max(Math.max(
                    highestProductOf3,
                    current * highestProductOf2),
                    current * lowestProductOf2);

            // Do we have a new highest product of two?
            highestProductOf2 = Math.max(Math.max(
                    highestProductOf2,
                    current * highest),
                    current * lowest);

            // Do we have a new lowest product of two?
            lowestProductOf2 = Math.min(Math.min(
                    lowestProductOf2,
                    current * highest),
                    current * lowest);

            // Do we have a new highest?
            highest = Math.max(highest, current);

            // Do we have a new lowest?
            lowest = Math.min(lowest, current);
        }

        return highestProductOf3;
    }
}

// O(n) time
// O(1) space