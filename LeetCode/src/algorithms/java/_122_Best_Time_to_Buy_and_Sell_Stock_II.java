// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii

class _122_Best_Time_to_Buy_and_Sell_Stock_II {
    public int maxProfit(int[] prices) {
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            int max = Math.max(0, prices[i] - prices[i - 1]);
            profit += max;
        }

        return profit;
    }
}