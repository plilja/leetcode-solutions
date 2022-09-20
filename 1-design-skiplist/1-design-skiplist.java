class Skiplist {
    private final Random random = new Random();
    private Node head = null;

    public Skiplist() {
        
    }
    
    public boolean search(int target) {
        List<Node> nodes = findOrLeftOf(target);
        if (!nodes.isEmpty() && nodes.get(nodes.size() - 1).val == target) {
            return true;
        } else {
            return false;
        }
    }
    
    public void add(int num) {
        if (head == null) {
            head = new Node(num);
        } else if (num < head.val) {
            int oldHeadVal = head.val;
            Node current = head;
            while (current != null) {
                current.val = num;
                current = current.down;
            }
            add(oldHeadVal);
        } else {
            Node prevLevelNew = null;
            List<Node> nodes = findOrLeftOf(num); 
            int i = nodes.size() - 1;
            while (true) {
                Node node;
                if (i >= 0) {
                    node = nodes.get(i);
                } else {
                    // above top level
                    Node newHead = new Node(head.val);
                    newHead.down = head;
                    head.up = newHead;
                    head = newHead;
                    node = newHead;
                }
                Node newNode = new Node(num);
                if (node.right != null) {
                    node.right.left = newNode;
                    newNode.right = node.right;
                }
                node.right = newNode;
                newNode.left = node;
                
                if (prevLevelNew != null) {
                    prevLevelNew.up = newNode;
                    newNode.down = prevLevelNew;
                }
                prevLevelNew = newNode;
                
                if (random.nextBoolean()) {
                    break;
                }
                i--;
            }
        }
    }
    
    
    public boolean erase(int num) {
        List<Node> nodes = findOrLeftOf(num);
        if (!nodes.isEmpty() && nodes.get(nodes.size() - 1).val == num) {
            eraseNode(nodes.get(nodes.size() - 1));
            return true;
        } else {
            return false;
        }
    }
    
    private void eraseNode(Node node) {
        if (node.left == null) {
            // deleting head
            if (node.right != null) {
                // make the second element the new head
                int newHeadVal = node.right.val;
                Node current = node;
                while (current != null) {
                    current.val = newHeadVal;
                    head = current;
                    current = current.up;
                }
                eraseNode(node.right);
            } else {
                // head is the one and only element in the list
                head = null;
            }
            return;
        }
        node.left.right = node.right;
        if (node.right != null) {
            node.right.left = node.left;
        }
        if (node.up != null) {
            eraseNode(node.up);
        }
    }
    
    private List<Node> findOrLeftOf(int num) {
        if (head == null) {
            return List.of();
        }
        List<Node> result = new ArrayList<>();
        Node currentOuter = head;
        while (currentOuter != null) {
            Node current = currentOuter;
            while (current.right != null && current.right.val <= num) {
                current = current.right;
            }
            result.add(current);
            currentOuter = current.down;
        }
        return result;
    }
    
    private class Node {
        Node left;
        Node right;
        Node up;
        Node down;
        int val;
        
        Node(int val) {
            this.val = val;
        }
    }
}

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */
