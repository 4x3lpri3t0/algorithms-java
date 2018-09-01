package DPBook._04_Knapsack;

import static java.lang.Math.*;
import static java.lang.System.*;

public class _04_Optimized {
    // Optimized bottom up solution with 1D cache.
    // Same as before but only save the cache of
    // i-1 and not all values of i.
    static int knapsack(Item[] items, int W) {
        int[] cache = new int[W + 1];
        for (Item i : items) {
            int[] newCache = new int[W + 1];
            for (int j = 0; j <= W; j++) {
                if (i.weight > j)
                    newCache[j] = cache[j];
                else
                    newCache[j] = max(
                            cache[j],
                            cache[j - i.weight] + i.value);
            }
            cache = newCache;
        }

        return cache[W];
    }

    public static void main(String[] args) {
        Item[] items = {
                new Item(2, 6),
                new Item(2, 10),
                new Item(3, 12)
        };

        int maxWeight = 5;
        out.println(knapsack(items, maxWeight)); // 22
    }
}