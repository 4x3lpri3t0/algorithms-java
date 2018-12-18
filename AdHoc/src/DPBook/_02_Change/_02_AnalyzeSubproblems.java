package DPBook._02_Change;

import java.util.Arrays;

import static java.lang.Math.*;
import static java.lang.System.*;

public class _02_AnalyzeSubproblems {
    static int[] coins = new int[]{1, 5, 10, 25};

    // Top down DP solution. Cache values as we compute them
    static int makeChange(int c) {
        // Initialize cache with values as -1
        int[] cache = new int[c + 1];
        Arrays.fill(cache, -1);
        cache[0] = 0;

        return makeChange(c, cache);
    }

    // Overloaded recursive function
    static int makeChange(int c, int[] cache) {
        // Return the value if it's in the cache
        if (cache[c] >= 0)
            return cache[c];

        int minCoins = Integer.MAX_VALUE;

        // Find the best coin
        for (int coin : coins) {
            if (c - coin >= 0) {
                int currMinCoins = makeChange(c - coin, cache);
                minCoins = min(minCoins, currMinCoins);
            }
        }

        // Save value into cache
        cache[c] = minCoins + 1;

        return cache[c];
    }

    public static void main(String[] args) {
        // Assuming American coins 1, 5, 10 and 25 cents
        out.println(makeChange(1)); // 1 (1)
        out.println(makeChange(6)); // 2 (5 + 1)
        out.println(makeChange(49)); // 7 (25 + 10 + 10 + 1 + 1 + 1 + 1)
    }
}
