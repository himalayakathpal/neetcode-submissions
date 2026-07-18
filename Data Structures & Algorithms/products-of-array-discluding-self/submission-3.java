class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefProduct = new int[n];
        int[] suffProduct = new int[n];
        int[] result = new int[n];
        int prod = 1;
        prefProduct[0] = 1;
        for (int i=1;i<n;i++) {
            prefProduct[i] = prefProduct[i-1] * nums[i-1];
        }
        suffProduct[n-1] = 1;
        for (int i=n-2;i>=0;i--) {
            suffProduct[i] = suffProduct[i+1] * nums[i+1];
        }

        for (int i=0;i<n;i++) {
            result[i] = prefProduct[i] * suffProduct[i];
        }
        return result;
    }
}  
