class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int one = 0;
        int two = 0;
        for (int i = n-2;i>=0;i--) {
            int temp = Math.max(nums[i] + two, one);
            two = one;
            one = temp;
        }

        for (int i = n-2;i>0;i--) {
            if (i == n-2) nums[i] = Math.max(nums[n-1], nums[n-2]);
            else nums[i] = Math.max(nums[i] + nums[i+2], nums[i+1]);
        }
        return Math.max(one, nums[1]);  
    }
}
