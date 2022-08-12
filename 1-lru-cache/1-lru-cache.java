class LRUCache {

    private Node head;
    private Node end;
    private final Map<Integer, Node> cache = new HashMap<>();
    private final int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        if (node != end) {
            if (node.prev != null) {
                node.prev.next = node.next;
            }
            if (node.next == null) {
                throw new IllegalStateException("Node without next pointer found that is not the end node");
            }
            if (node == head) {
                head = node.next;
            }
            node.next.prev = node.prev;
            node.next = null;
            
            end.next = node;
            node.prev = end;
            end = node;
        }
        return node.value;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            get(key);
            cache.get(key).value = value;
            return;
        }
        if (cache.size() == capacity) {
            // evict oldest
            cache.remove(head.key);
            head = head.next;
            if (head != null) { // Size 1
                head.prev = null;
            }
        }
        Node newNode = new Node(key, value);
        newNode.prev = end;
        if (end != null) {
            end.next = newNode;
        }
        end = newNode;
        if (head == null) {
            head = newNode;
        }
        cache.put(key, newNode);
    }
    
    private static class Node {
        Node prev;
        Node next;
        int value;
        int key;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
