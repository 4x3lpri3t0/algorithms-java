package DPBook._02_Change;

import static java.lang.System.*;

public class _03_Turn {
    static int[] coins = new int[]{1, 5, 10, 25};

    // Bottom up DP solution.
    // Iteratively compute number of coins for
    // larger and larger amounts of change
    static int makeChange(int c) {
        int[] cache = new int[c + 1];
        for (int i = 1; i <= c; i++) {
            int minCoins = Integer.MAX_VALUE;

            // Try removing each coin from the total
            // and see which requires the fewest extra coins
            for (int coin : coins) {
                if (i - coin >= 0) {
                    int currCoins = cache[i - coin] + 1;
                    if (currCoins < minCoins) {
                        minCoins = currCoins;
                    }
                }
            }
            cache[i] = minCoins;
        }

        return cache[c];
    }

    public static void main(String[] args) {
        // Assuming American coins 1, 5, 10 and 25 cents
        out.println(makeChange(1)); // 1 (1)
        out.println(makeChange(6)); // 2 (5 + 1)
        out.println(makeChange(49)); // 7 (25 + 10 + 10 + 1 + 1 + 1 + 1)
    }
}
