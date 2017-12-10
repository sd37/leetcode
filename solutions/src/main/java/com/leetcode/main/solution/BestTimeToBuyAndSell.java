// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
// Status = AC

package com.leetcode.main.solution;

public class BestTimeToBuyAndSell {
  public int maxProfit(int[] prices) {
    if(prices == null || prices.length == 0) {
      return 0;
    }

    int minSoFar = prices[0];
    int maxProfit = 0;

    for (int i = 1; i < prices.length; i++) {
      minSoFar = Math.min(minSoFar, prices[i]);
      maxProfit = Math.max(maxProfit, prices[i] - minSoFar);
    }

    return maxProfit;
  }
}
