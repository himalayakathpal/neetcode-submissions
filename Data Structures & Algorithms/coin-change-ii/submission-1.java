class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for (int i=n;i>=0;i--) {
            for (int j=0;j<=amount;j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                if (i == n) {
                    dp[i][j] = 0;
                    continue;
                }
                if (coins[i] <= j) {
                    dp[i][j] = dp[i][j-coins[i]] + dp[i+1][j];
                } else {
                    dp[i][j] = dp[i+1][j];
                }
            }
        }
        return dp[0][amount];
    }
}
