class MaxStack {
    private int counter = 0;
    private final TreeMap<Integer, TreeSet<Node>> sorted = new TreeMap<>();
    private Node tail = null;

    public MaxStack() {
        
    }
    
    public void push(int x) {
        Node oldTail = tail;
        tail = new Node();
        tail.value = x;
        tail.id = counter;
        counter++;
        if (oldTail != null) {
            tail.prev = oldTail;
            oldTail.next = tail;
        }
        sorted.computeIfAbsent(x, k -> new TreeSet<>((a, b) -> b.id - a.id)).add(tail);
    }
    
    public int pop() {
        int result = tail.value;
        remove(tail);
        return result;
    }
    
    public int top() {
        return tail.value;
    }
    
    public int peekMax() {
        var entry = sorted.lastEntry();
        return entry.getKey();
    }
    
    public int popMax() {
        var entry = sorted.lastEntry();
        int result = entry.getKey();
        TreeSet<Node> nodes = entry.getValue();
        Node node = nodes.first();
        remove(node);
        return result;
    }
    
    private void remove(Node node) {
        TreeSet<Node> nodes = sorted.get(node.value);
        nodes.remove(node);
        if (nodes.isEmpty()) {
            sorted.remove(node.value);
        }
        if (node == tail) {
            tail = node.prev;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
    }
    
    private class Node {
        private Node prev;
        private Node next;
        private int value;
        private int id;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
