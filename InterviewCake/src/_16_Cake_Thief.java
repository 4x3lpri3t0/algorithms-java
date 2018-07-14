// Greedy approach to keep track of the max
// value we’ve seen so far.

// 1- If the cake weighs 2 kg, it would fill up our whole
// capacity if we just took one. So we just need to see if
// the cake's value is higher than our current
// maxValueAtCapacity2.

// 2- If the cake weighs 1 kg, we could take one,
// and we'd still have 1 kg of capacity left.
// How do we know the best way to fill that extra capacity?
// We can use the max value at capacity 1.
// We’ll see if adding the cake's value to the max value at
// capacity 1 is better than our current maxValueAtCapacity2.

class _16_Cake_Thief {
    class CakeType {
        int weight;
        int value;

        public CakeType(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public long maxDuffelBagValue(CakeType[] cakeTypes, int weightCapacity) {
        // We make an array to hold the maximum possible value at every
        // duffel bag weight capacity from 0 to weightCapacity
        // starting each index with value 0
        long[] maxValuesAtCapacities = new long[weightCapacity + 1];

        for (int currentCapacity = 0; currentCapacity <= weightCapacity; currentCapacity++) {

            // Set a variable to hold the max monetary value so far for currentCapacity
            long currentMaxValue = 0;

            for (CakeType cakeType : cakeTypes) {
                // If a cake weighs 0 and has a positive value the value of our duffel bag is infinite!
                if (cakeType.weight == 0 && cakeType.value != 0) {
                    throw new RuntimeException();
                }

                // If the current cake weighs as much or less than the current weight capacity
                // it's possible taking the cake would get a better value
                if (cakeType.weight <= currentCapacity) {

                    // So we check: should we use the cake or not?
                    // if we use the cake, the most kilograms we can include in addition to the cake
                    // we're adding is the current capacity minus the cake's weight. we find the max
                    // value at that integer capacity in our array maxValuesAtCapacities
                    long maxValueUsingCake = cakeType.value + maxValuesAtCapacities[currentCapacity - cakeType.weight];

                    // It's worth taking the cake?
                    currentMaxValue = Math.max(maxValueUsingCake, currentMaxValue);
                }
            }

            // Add each capacity's max value to our array so we can use them
            // when calculating all the remaining capacities
            maxValuesAtCapacities[currentCapacity] = currentMaxValue;
        }

        return maxValuesAtCapacities[weightCapacity];
    }
}