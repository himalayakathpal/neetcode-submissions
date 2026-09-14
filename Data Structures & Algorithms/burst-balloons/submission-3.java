class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] numsCopy = new int[nums.length+2];
        numsCopy[0] = 1;
        for (int i=0;i<nums.length;i++) {
            numsCopy[i+1] = nums[i];
        }
        numsCopy[nums.length+1] = 1;
        int[][] dp = new int[n+3][n+3];
        for (int i = n;i>=1;i--) {
            for (int j = i;j<=n;j++) {
                for (int k=i;k<=j;k++) {
                    int coins = dp[i][k-1] + dp[k+1][j] + (numsCopy[i-1] * numsCopy[k] * numsCopy[j+1]);
                    dp[i][j] = Math.max(dp[i][j], coins);
                }
            }
        }
        return dp[1][n];
    }
}
