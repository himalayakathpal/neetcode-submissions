class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] suffixProduct = new int[n];
        int[] prefixProduct = new int[n];
        int[] result = new int[n];
        int currentProd = 1;
        for (int i=n-1;i>=0;i--) {
            currentProd = suffixProduct[i] = nums[i] * currentProd;
        }
        currentProd = 1;
        for (int i=0;i<n;i++) {
            result[i] = currentProd;
            if (i<n-1) result[i] = suffixProduct[i+1] * result[i];
            currentProd = currentProd * nums[i];
        }

        return result;
    }
}  
