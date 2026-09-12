class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for (int i=1;i<=amount;i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int k = 0;k<coins.length;k++) {
                if (coins[k] <= i && dp[i-coins[k]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(1+ dp[i-coins[k]], dp[i]);
                }
            }
        }
        for (int i=0;i<=amount;i++) {
            if (dp[i] == Integer.MAX_VALUE) dp[i] = -1;
        }
        return dp[amount];
    }
}
