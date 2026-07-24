class Solution {
    public int maxArea(int[] heights) {
       int i = 0;
       int j = heights.length-1;
       int maxiArea = 0;
       while (i<j) {
        int currArea = Math.min(heights[i], heights[j]) * (j-i);
        maxiArea = Math.max(maxiArea, currArea);
        if (heights[i] < heights[j]) i++;
        else j--;
       }
       return maxiArea; 
    }
}
