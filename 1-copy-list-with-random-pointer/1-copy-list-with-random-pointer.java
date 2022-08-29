/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> oldToNew = new HashMap<>();
        Node result = null;
        Node prev = null;
        Node currentNew = null;
        Node currentOrig = head;
        while (currentOrig != null) {
            Node newNode = new Node(currentOrig.val);
            if (result == null) {
                result = newNode;
            }
            if (prev != null) {
                prev.next = newNode;
            }
            newNode.random = currentOrig.random;
            oldToNew.put(currentOrig, newNode);
            
            prev = newNode;
            currentOrig = currentOrig.next;
        }
        currentNew = result;
        while (currentNew != null) {
            if (currentNew.random != null) {
                currentNew.random = oldToNew.get(currentNew.random);
            }
            currentNew = currentNew.next;
        }
        
        return result;
    }
}
