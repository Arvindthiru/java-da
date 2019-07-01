class MinStack {
    Stack<Integer> orig_stack;
    Stack<Integer> min_stack;
    
    /** initialize your data structure here. */
    public MinStack() {
        orig_stack = new Stack<Integer>();
        min_stack = new Stack<Integer>();
    }
    
    public void push(int x) {
        if(orig_stack.isEmpty())
        {
            orig_stack.push(x);
            min_stack.push(x);
        }
        else
        {
            orig_stack.push(x);
            if(x<min_stack.peek())
            {
                min_stack.push(x);
            }
            else
            {
                min_stack.push(min_stack.peek());
            }
        }
        
    }
    
    public void pop() {
        orig_stack.pop();
        min_stack.pop();
    }
    
    public int top() {
        return orig_stack.peek();
    }
    
    public int getMin() {
        return min_stack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
