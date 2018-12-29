package Arrays;

import static java.lang.System.out;

class Tuple<X, Y> {
    public X x;
    public Y y;

    public Tuple(X x, Y y) {
        this.x = x;
        this.y = y;
    }
}

public class StockPrices {
    public static Tuple find_buy_sell_stock_prices(int[] array) {
        if (array == null || array.length < 2)
            return null;

        int lowest = Integer.MAX_VALUE;
        int buyPrice = array[0];
        int sellPrice = array[1];
        int maxProfit = Integer.MIN_VALUE;

        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            if (current < lowest) {
                lowest = current;
            }

            if (current - lowest > maxProfit) {
                maxProfit = current - lowest;
                buyPrice = lowest;
                sellPrice = current;
            }
        }

        return new Tuple<>(buyPrice, sellPrice);
    }

    public static void main(String[] args) {
        int[] stocks = {1, 2, 3, 4, 3, 2, 1, 2, 5};
        Tuple<Integer, Integer> result = find_buy_sell_stock_prices(stocks);
        out.println(result.x + " " + result.y);

        stocks = new int[]{12, 5, 9, 19, 8};
        result = find_buy_sell_stock_prices(stocks);
        out.println(result.x + " " + result.y);
    }
}
