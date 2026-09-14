class Solution {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int currMax = nums[0];
        for (int i=1;i<nums.length;i++) {
            currMax = Math.max(nums[i], currMax+nums[i]);
            result = Math.max(result, currMax);
        }
        return result;
    }
}
