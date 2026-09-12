class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num: nums) sum+=num;
        if (sum%2 == 1) return false;
        int halfSum = sum/2;
        int n = nums.length;

        boolean[] prev = new boolean[halfSum+1];
        prev[0] = true;

        for (int i=n-1;i>=0;i--) {
            boolean[] curr = new boolean[halfSum+1];
            for (int j = 0;j<=halfSum;j++) {
                if (j == 0) {
                    curr[j] = true;
                    continue;
                }
                curr[j] = nums[i] <=j ? prev[j] || prev[j-nums[i]] : prev[j];
            }
            prev = curr;
        }
        return prev[halfSum];
    }
}
