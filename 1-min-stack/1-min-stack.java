class MinStack {
    private final Deque<Integer> min = new ArrayDeque<>();
    private final Deque<Integer> elem = new ArrayDeque<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        elem.add(val);
        if (min.isEmpty()) {
            min.add(val);
        } else {
            min.add(Math.min(min.peekLast(), val));
        }
    }
    
    public void pop() {
        elem.removeLast();
        min.removeLast();
    }
    
    public int top() {
        return elem.peekLast();
    }
    
    public int getMin() {
        return min.peekLast();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
