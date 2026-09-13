class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int nextDayBuy = 0;
        int nextDaySell = 0;
        int nextNextBuy = 0;
        int currDayBuy = 0;
        int currDaySell = 0;
        for (int i = n-1;i>=0;i--) {
            currDaySell = Math.max(nextDaySell, prices[i] + nextNextBuy);
            currDayBuy = Math.max(nextDayBuy, nextDaySell - prices[i]);
            nextNextBuy = nextDayBuy;
            nextDayBuy = currDayBuy;
            nextDaySell = currDaySell;
        }
        return nextDayBuy;
    }
}