class MinStack {

    class MinElement {

        int val;
        int min;
        public MinElement(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    int min;
    Stack<MinElement> stack;
    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        this.min = Math.min(val, this.min);
        MinElement minElement = new MinElement(val, this.min);
        stack.push(minElement);
    }
    
    public void pop() {
        stack.pop();
        if(!stack.isEmpty()) {
            this.min = stack.peek().min;
        } else {
            this.min = Integer.MAX_VALUE;
        }
    }
    
    public int top() {
        MinElement minElement = stack.peek();
        return minElement.val;
    }
    
    public int getMin() {
        MinElement minElement = stack.peek();
        return minElement.min;
    }
}
