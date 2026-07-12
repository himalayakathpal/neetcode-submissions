class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int rightProd = 1;
        for (int i=n-1;i>=0;i--) {
            result[i] = rightProd;
            rightProd *= nums[i];
        }
        int leftProd = 1;
        for (int i=0;i<n;i++) {
            result[i] *= leftProd;
            leftProd *= nums[i];
        }

        return result;
    }
}  
