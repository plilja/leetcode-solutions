class AllOne {
    private final Map<String, Node> stringToNode = new HashMap<>();
    private Node head;
    private Node tail;

    public AllOne() {
        head = new Node(Integer.MIN_VALUE);
        tail = new Node(Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
    }
    
    public void inc(String key) {
        Node node = stringToNode.get(key);
        if (node == null) {
            Node insertNode = head.insert(key, 1);
            stringToNode.put(key, insertNode);
        } else {
            Node prev = node.prev;
            node.remove(key);
            Node insertNode = prev.insert(key, node.count + 1);
            stringToNode.put(key, insertNode);
        }
    }
    
    public void dec(String key) {
        Node node = stringToNode.get(key);
        Node prev = node.prev;
        node.remove(key);
        if (node.count > 1) {
            Node insertNode = prev.insert(key, node.count - 1);
            stringToNode.put(key, insertNode);
        } else {
            stringToNode.remove(key);
        }
    }
    
    public String getMaxKey() {
        if (tail.prev != head) {
            return tail.prev.strings.iterator().next();
        } else {
            return "";
        }
    }
    
    public String getMinKey() {
        if (head.next != tail) {
            return head.next.strings.iterator().next();
        } else {
            return "";
        }
    }
    
    private class Node {
        Node prev = null;
        Node next = null;
        int count;
        LinkedHashSet<String> strings = new LinkedHashSet<>();
        
        Node(int count) {
            this.count = count;
        }
        
        Node insert(String key, int count) {
            if (this.count == count) {
                strings.add(key);
                return this;
            } else if (next.count > count) {
                Node newNode = new Node(count);
                newNode.strings.add(key);
                next.prev = newNode;
                newNode.next = next;
                next = newNode;
                newNode.prev = this;
                return newNode;
            } else {
                return next.insert(key, count);
            }
        }
        
        void remove(String key) {
            strings.remove(key);
            if (strings.isEmpty()) {
                prev.next = next;
                next.prev = prev;
            }
        }
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */