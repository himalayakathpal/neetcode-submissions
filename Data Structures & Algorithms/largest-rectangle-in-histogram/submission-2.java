class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxi = Integer.MIN_VALUE;
        int n = heights.length;
        for (int i = n-1;i>=0;i--) {
            while (st.size()>0 && heights[st.peek()] > heights[i]) {
                int temp =st.pop();
                int area = st.size() == 0 ? (n-1-i) * heights[temp] : (st.peek()-1-i) * heights[temp];
                maxi = Math.max(maxi, area); 
            }
            st.push(i);
        }
        while(st.size()>0) {
            int temp =st.pop();
            int area = st.size() == 0 ? (n) * heights[temp] : st.peek() * heights[temp];
                maxi = Math.max(maxi, area); 
        }

        return maxi;
    }
}
