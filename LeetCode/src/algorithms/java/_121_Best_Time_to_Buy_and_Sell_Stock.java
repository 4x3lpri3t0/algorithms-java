class _121_Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        // Keep track of both min and max
        int max = 0;
        int sofarMin = prices[0];
        for (int i = 0; i < prices.length; ++i) {
            if (prices[i] > sofarMin) {
                max = Math.max(max, prices[i] - sofarMin);
            } else {
                sofarMin = prices[i];
            }
        }

        return max;
    }
}