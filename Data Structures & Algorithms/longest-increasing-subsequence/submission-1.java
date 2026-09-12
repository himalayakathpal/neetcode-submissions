class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int maxi = 1;
        dp[n-1] = 1;
        for (int i=n-2;i>=0;i--) {
            dp[i] = 1;
            for (int k=i+1;k<n;k++) {
                if (nums[k]>nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[k]);
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }
        return maxi;
    }
}
