package DPBook._04_Knapsack;

import static java.lang.Math.*;
import static java.lang.System.*;

public class _01_First {
    // Naive brute force solution. Recursively include or exclude
    // each item to try every possible solution.
    static int knapsack(Item[] items, int W) {
        return knapsack(items, W, 0);
    }

    // Overloaded recursive function
    static int knapsack(Item[] items, int W, int i) {
        // We've gone through all the items?
        if (i == items.length)
            return 0;

        // If the item is too big to fill the
        // remaining space, skip it
        if (W - items[i].weight < 0)
            return knapsack(items, W, i + 1);

        // Find max of including and not including current item
        return max(
                knapsack(items, W - items[i].weight, i + 1) + items[i].value,
                knapsack(items, W, i + 1));
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
