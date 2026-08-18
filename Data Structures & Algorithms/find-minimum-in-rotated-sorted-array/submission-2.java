class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int mini = Integer.MAX_VALUE;
        while(start<=end) {
            int mid = (start+end)/2;
            mini = Math.min(mini, nums[mid]);
                if (nums[mid] <= nums[end]) {
                    end = mid-1;
                } else {
                    start = mid+1;
                }
        }
        return mini;
    }
}
