class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        
        this.stack = new Stack();
        this.minStack = new Stack();
    }
    
    public void push(int val) {
        
        stack.push(val);
        if(minStack.isEmpty() || val<=minStack.peek()){
            minStack.push(val);
        }

    }
    
    public void pop() {
        
        if(!stack.isEmpty() && minStack.peek().equals(stack.peek())){
            minStack.pop();
            stack.pop();
        }else{
            stack.pop();
        }
        
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
