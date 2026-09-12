class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        for (int i = n-2;i>=0;i--) {
            if (i == n-2) nums[i] = Math.max(nums[i], nums[i+1]);
            else nums[i] = Math.max(nums[i] + nums[i+2], nums[i+1]);
        }
        return nums[0];   
    }
}
