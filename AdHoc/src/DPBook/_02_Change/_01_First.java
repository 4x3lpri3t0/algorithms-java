package DPBook._02_Change;

import static java.lang.Math.*;
import static java.lang.System.*;

public class _01_First {
    static int[] coins = new int[]{1, 5, 10, 25};

    // Brute force solution. Go through every
    // combination of coins that sum up to c to
    // find the minimum number
    static int makeChange(int c) {
        if (c == 0)
            return 0;

        int minCoins = Integer.MAX_VALUE;

        // Try removing each coin from the total and
        // see how many more coins are required
        for (int coin : coins) {
           // Skip a coin if its value is greater
           // than the amount remaining
           if (c - coin >= 0) {
               int currMinCoins = makeChange(c - coin);
               minCoins = min(minCoins, currMinCoins);
           }
        }

        // Add back the coin removed recursively
        return minCoins + 1;
    }

    public static void main(String[] args) {
        // Assuming American coins 1, 5, 10 and 25 cents
        out.println(makeChange(1)); // 1 (1)
        out.println(makeChange(6)); // 2 (5 + 1)
        out.println(makeChange(49)); // 7 (25 + 10 + 10 + 1 + 1 + 1 + 1)
    }
}
