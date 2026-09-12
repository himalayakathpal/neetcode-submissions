class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num: nums) sum+=num;
        if (sum%2 == 1) return false;
        int halfSum = sum/2;
        int n = nums.length;

        boolean[][] dp = new boolean[n+1][halfSum+1];
        for (int i=n;i>=0;i--) {
            for (int j = 0;j<=halfSum;j++) {
                if (j == 0) {
                    dp[i][j] = true;
                    continue;
                }
                if (i == n) {
                    dp[i][j] = false;
                    continue;
                }
                dp[i][j] = nums[i] <=j ? dp[i+1][j] || dp[i+1][j-nums[i]] : dp[i+1][j];
            }
        }
        return dp[0][halfSum];
    }
}
