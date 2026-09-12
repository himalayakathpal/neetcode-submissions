class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int[] temp = nums.clone();;
        temp[n-1] = 0;
        for (int i = n-2;i>=0;i--) {
            if (i == n-2) temp[i] = Math.max(temp[n-1], temp[n-2]);
            else temp[i] = Math.max(temp[i] + temp[i+2], temp[i+1]);
        }

        for (int i = n-2;i>0;i--) {
            if (i == n-2) nums[i] = Math.max(nums[n-1], nums[n-2]);
            else nums[i] = Math.max(nums[i] + nums[i+2], nums[i+1]);
        }
        return Math.max(temp[0], nums[1]);  
    }
}
