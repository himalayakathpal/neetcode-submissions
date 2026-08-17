class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        result[n-1] = 0;
        Stack<Integer> st = new Stack<>();
        st.push(n-1);
        for (int i = n-2 ;i>=0;i--) {
            while(st.size()>0 && temperatures[st.peek()] <= temperatures[i]) {
                st.pop();
            }
            result[i] = st.size() == 0 ? 0 :  st.peek() - i;
            st.push(i);
        }

        return result;

    }
}
