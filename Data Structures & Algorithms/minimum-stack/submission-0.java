class MinStack {
     Stack<Integer> mainStack;
     Stack<Integer> minStack;
    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();       
    }
    
    public void push(int val) {
        this.mainStack.push(val);
        if (minStack.isEmpty() || minStack.peek() >= val) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        if (!mainStack.isEmpty()) {
            int val = mainStack.pop();
        if (!minStack.isEmpty() && minStack.peek() == val) {
            minStack.pop();
        }            
        }

    }
    
    public int top() {
        if (!mainStack.isEmpty()) {
            return mainStack.peek();
        } 
        return -1;
    }
    
    public int getMin() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        } 
        return -1;
        
    }
}
