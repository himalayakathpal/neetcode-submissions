class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];
        dp[n-1] = 0;
        for (int i = n-2;i>=0;i--) {
            dp[i] = Math.max(dp[i], dp[i+1]);
            for (int k=i+1;k<n;k++) {
                if (k+2<n) {
                    dp[i] = Math.max(dp[i], prices[k]-prices[i] + dp[k+2]);
                } else {
                    dp[i] = Math.max(dp[i], prices[k]-prices[i]);
                }
            }
        }
        return dp[0];
    }
}