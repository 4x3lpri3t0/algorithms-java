// Use waysOfDoingNCents, where the index is the amount
// and the value at each index is the number of ways of getting that amount.

class _05_Making_Change {
    public static int changePossibilitiesBottomUp(int amount, int[] denominations) {
        // Ways of doing N cents
        // Array of zeros from 0..amount
        int[] ways = new int[amount + 1];
        ways[0] = 1;

        for (int coin : denominations) {
            for (int highAmount = coin; highAmount <= amount; highAmount++) {
                int highAmountLeft = highAmount - coin;
                ways[highAmount] += ways[highAmountLeft];
            }
        }

        return ways[amount];
    }

}
