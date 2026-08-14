class MinStack {
    Stack<Long> st;
    long mini;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if (st.size() == 0) {
            st.push(0L);
            mini = val;
            return;
        }
        st.push(val - mini);
        mini = Math.min(mini, val);
    }
    
    public void pop() {
        if(!st.isEmpty()){
            if (st.peek()<0) {
                mini = mini - st.peek();
            }
            st.pop();
        }

    }
    
    public int top() {
        if (!st.isEmpty()) {
            long top = st.peek();
            return st.peek() >=0 ?  (int) (top + mini): (int) mini;
        } 
        return -1;
    }
    
    public int getMin() {
        if (!st.isEmpty()) {
            return (int) mini;
        } 
        return -1;
        
    }
}
