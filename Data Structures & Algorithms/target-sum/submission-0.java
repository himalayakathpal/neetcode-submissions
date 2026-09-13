class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer>[] dp = new HashMap[n+1];
        for (int i=0;i<=n;i++) {
            dp[i] = new HashMap<>();
        }
        dp[n].put(target,1);
        for (int i = n-1;i>=0;i--) {
            for (Map.Entry<Integer,Integer> entry: dp[i+1].entrySet()) {
                int ways = entry.getValue();
                int sum = entry.getKey();
                dp[i].put(sum+nums[i], dp[i].getOrDefault(sum+nums[i],0) + ways);
                dp[i].put(sum-nums[i], dp[i].getOrDefault(sum-nums[i],0) + ways);
            }
        }
        return dp[0].getOrDefault(0,0);
    }
}
