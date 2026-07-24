class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] rightMax = new int[n];
        rightMax[n-1] = 0;

        for (int i = n-2;i>=0;i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i+1]);
        }
        int leftMax = 0;
        int totalWater = 0;
        for (int i=1;i<n;i++) {
            leftMax = Math.max(leftMax,height[i-1]);
            int heightPossible = Math.min(leftMax,rightMax[i]);
            totalWater+=  heightPossible - height[i] > 0 ? heightPossible - height[i] : 0;
        }

        return totalWater;
    }
}
