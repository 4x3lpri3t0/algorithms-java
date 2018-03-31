// * Keep track of the lowest price we’ve seen so far
// * See if we can get a better profit

class _01_stock_price {
    public static int getMaxProfit(int[] stockPrices) {
        if (stockPrices.length < 2) {
            throw new IllegalArgumentException(
                    "Getting a profit requires at least 2 prices");
        }

        // We'll greedily update minPrice and maxProfit, so we initialize
        // them to the first price and the first possible profit
        int minPrice = stockPrices[0];
        int maxProfit = stockPrices[1] - stockPrices[0];

        // Start at the second (index 1) time
        // We can't sell at the first time, since we must buy first,
        // and we can't buy and sell at the same time!
        // If we started at index 0, we'd try to buy *and* sell at time 0.
        // this would give a profit of 0, which is a problem if our
        // maxProfit is supposed to be *negative* -- we'd return 0.
        for (int i = 1; i < stockPrices.length; i++) {
            int currentPrice = stockPrices[i];

            // See what our profit would be if we bought at the
            // min price and sold at the current price
            int potentialProfit = currentPrice - minPrice;

            // Update maxProfit if we can do better
            maxProfit = Math.max(maxProfit, potentialProfit);

            // Update minPrice so it's always
            // the lowest price we've seen so far
            minPrice = Math.min(minPrice, currentPrice);
        }

        return maxProfit;
    }
}

// O(n) time
// O(1) space