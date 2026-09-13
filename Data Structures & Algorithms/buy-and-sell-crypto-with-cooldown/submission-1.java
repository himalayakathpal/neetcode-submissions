class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        dp[n][0] = 0;
        dp[n][1] = 0;
        for (int i = n-1;i>=0;i--) {
            if (i == n-1) {
                dp[i][0] = prices[i];
                dp[i][1] = 0;
                continue;
            }
            dp[i][0] = Math.max(dp[i+1][0], prices[i] + dp[i+2][1]);
            dp[i][1] = Math.max(dp[i+1][1], dp[i+1][0] - prices[i]);
        }
        return dp[0][1];
    }
}