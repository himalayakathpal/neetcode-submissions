class Solution {
    public boolean canJump(int[] nums) {
       int maxIndex = 0;
       int i=0;
       int target = nums.length-1;
       while (i<=maxIndex) {
        maxIndex = Math.max(maxIndex, i + nums[i]);
        if (maxIndex>=target) return true;
        i++;
       }
       return false;
    }
}
