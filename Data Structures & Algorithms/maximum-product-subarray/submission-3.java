class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        int preMax = 1;
        int suffMax = 1;
        int n = nums.length;
        for (int i=0;i<nums.length;i++) {
            if (preMax == 0) preMax = 1;
            if (suffMax == 0) suffMax = 1;
            preMax = preMax* nums[i];
            suffMax = suffMax* nums[n-1-i];
            maxProduct = Math.max(maxProduct, Math.max(preMax, suffMax));
        }
        return maxProduct;

    }
}
