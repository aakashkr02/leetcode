class Solution {
    public int maxProfit(int[] prices, int fee) {

        int cash = 0;
        int hold = -prices[0];

        for (int i = 1; i < prices.length; i++) {

            int oldCash = cash;
            int oldHold = hold;

            // Sell today or don't sell
            cash = Math.max(oldCash, oldHold + prices[i] - fee);

            // Buy today or keep holding
            hold = Math.max(oldHold, oldCash - prices[i]);
        }

        return cash;
    }
}