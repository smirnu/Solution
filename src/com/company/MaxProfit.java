package com.company;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        boolean isSold = false;
        int profit = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] - prices[i + 1] < 1) {
                if (!isSold) {
                    profit -= prices[i];
                    isSold = true;
                }
            } else {
                if (isSold) {
                    profit += prices[i];
                    isSold = false;
                }
            }
        }
        if (isSold) profit += prices[prices.length - 1];
        return profit;
    }
}
