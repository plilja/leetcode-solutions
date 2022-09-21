class MyQueue {
    private final Deque<Integer> stackNewestTop = new ArrayDeque<>();
    private final Deque<Integer> stackOldestTop = new ArrayDeque<>();

    public MyQueue() {
    }
    
    public void push(int x) {
        stackNewestTop.add(x);
    }
    
    public int pop() {
        ensureOldestTopContainsOneOrMoreElement();
        return stackOldestTop.pollLast();
    }
    
    public int peek() {
        ensureOldestTopContainsOneOrMoreElement();
        return stackOldestTop.peekLast();
    }
    
    private void ensureOldestTopContainsOneOrMoreElement() {
        if (stackOldestTop.isEmpty()) {
            while (!stackNewestTop.isEmpty()) {
                int n = stackNewestTop.pollLast();
                stackOldestTop.add(n);
            }
        }
    }
    
    public boolean empty() {
        return stackNewestTop.isEmpty() && stackOldestTop.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
