class Solution {
    public int search(int[] nums, int target) {
       int n = nums.length;
       int start = 0;
       int end = n-1;

       while (start<=end) {
            int mid = (start+end)/2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] <= nums[end] && nums[mid] < target && nums[end]>=target) {
                start = mid+1;
            } else if (nums[start] <= nums[mid] && nums[start] <= target && nums[mid]>target) {
                end = mid-1;
            } else if (nums[mid] <= nums[end]) {
                end = mid-1;
            } else if (nums[start] <= nums[mid]) {
                start = mid+1;
            }
       }

       return -1;
    }
}
