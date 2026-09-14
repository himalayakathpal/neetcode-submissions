class Solution {
    public int maxCoinsHelper(int start, int end, int[] nums,int[][] dp) {
        if (start>end) return 0;
        if (dp[start][end] != -1) return dp[start][end];
        int coins = 0;
        for (int k = start;k<=end;k++) {
            int total = nums[start-1]* nums[k] * nums[end+1];
            total+= maxCoinsHelper(start, k-1, nums,dp);
            total+= maxCoinsHelper(k+1, end, nums, dp);
            coins = Math.max(coins, total);
        }
        dp[start][end] = coins;
        return coins;
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] numsCopy = new int[nums.length+2];
        numsCopy[0] = 1;
        for (int i=0;i<nums.length;i++) {
            numsCopy[i+1] = nums[i];
        }
        numsCopy[nums.length+1] = 1;
        int[][] dp = new int[n+3][n+3];
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return maxCoinsHelper(1, nums.length, numsCopy, dp);
    }
}
