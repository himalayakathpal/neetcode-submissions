class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] suffixProduct = new int[n];
        int[] prefixProduct = new int[n];
        int[] result = new int[n];
        int currentProd = 1;
        for (int i=0;i<n;i++) {
            currentProd = prefixProduct[i] = nums[i] * currentProd;
            result[i] = 1;
        }
        currentProd = 1;
        for (int i=n-1;i>=0;i--) {
            currentProd = suffixProduct[i] = nums[i] * currentProd;
        }
        for (int i=0;i<n;i++) {
            if (i >0) result[i] = prefixProduct[i-1] * result[i];
            if (i<n-1) result[i] = suffixProduct[i+1] * result[i];
        }

        return result;
    }
}  
