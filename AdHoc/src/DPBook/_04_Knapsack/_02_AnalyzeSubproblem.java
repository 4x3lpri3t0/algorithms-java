package DPBook._04_Knapsack;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.*;
import static java.lang.System.*;

public class _02_AnalyzeSubproblem {
    // Top down DP solution.
    // Cache may be sparse -> Cache values in HashMap
    static int knapsack(Item[] items, int W) {
        // Map: i -> W -> value
        Map<Integer, Map<Integer, Integer>> cache = new HashMap<>();

        return knapsack(items, W, 0, cache);
    }

    // Overloaded recursive function
    private static int knapsack(Item[] items, int W, int i,
                                Map<Integer, Map<Integer, Integer>> cache) {
        if (i == items.length)
            return 0;

        //Check if the value is in the cache
        if (!cache.containsKey(i))
            cache.put(i, new HashMap<>());

        Integer cached = cache.get(i).get(W);

        if (cached != null)
            return cached;

        // Compute the item and add it to the cache
        int toReturn;
        if (W - items[i].weight < 0) {
            toReturn = knapsack(items, W, i + 1, cache);
        } else {
            toReturn = max(
                    knapsack(items, W - items[i].weight, i + 1, cache)
                            + items[i].value,
                    knapsack(items, W, i + 1, cache));
        }

        cache.get(i).put(W, toReturn);
        return toReturn;
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