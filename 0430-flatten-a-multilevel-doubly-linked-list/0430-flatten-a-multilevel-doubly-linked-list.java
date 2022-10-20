/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node current = head;
        while (current != null) {
            Node nextTmp = current.next;
            if (current.child != null) {
                Node childFlattened = flatten(current.child);
                current.child = null;
                childFlattened.prev = current;
                current.next = childFlattened;
                while (current.next != null) {
                    current = current.next;
                }
            }
            if (nextTmp != null) {
                nextTmp.prev = current;
            }
            current.next = nextTmp;
            current = nextTmp;
        }
        return head;
    }
}