public class BuyAndSellStocks3 {
  public int maxProfit(int[] prices) {
    int buy = prices[0];
    int maxProfit = 0;
    int[] lprofit = new int[prices.length];
    for (int i = 0; i < prices.length; i++) {
      if (prices[i] - buy > maxProfit) {
        maxProfit = prices[i] - buy;
        lprofit[i] = maxProfit;
      } else {
        lprofit[i] = maxProfit;
      }
      if (prices[i] < buy) {
        buy = prices[i];
      }
    }

    int sell = prices[prices.length - 1];
    int[] rprofit = new int[prices.length];
    maxProfit = 0;
    for (int i = prices.length - 1; i >= 0; i--) {
      if (sell - prices[i] > maxProfit) {
        maxProfit = sell - prices[i];
        rprofit[i] = maxProfit;
      } else {
        rprofit[i] = maxProfit;
      }
      if (prices[i] > sell) {
        sell = prices[i];
      }
    }

    int ans = Integer.MIN_VALUE;
    for (int i = 0; i < prices.length; i++) {
      int curr = lprofit[i] + rprofit[i];
      if (curr > ans) {
        ans = curr;
      }
    }
    return ans;
  }
}
