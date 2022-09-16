/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        int pDepth = getDepth(p);
        int qDepth = getDepth(q);
        Node pCurrent = p;
        Node qCurrent = q;
        while (pDepth > qDepth) {
            pCurrent = pCurrent.parent;
            pDepth--;
        }
        while (pDepth < qDepth) {
            qCurrent = qCurrent.parent;
            qDepth--;
        }
        while (pCurrent != qCurrent) {
            pCurrent = pCurrent.parent;
            qCurrent = qCurrent.parent;
        }
        return pCurrent;
    }
    
    private int getDepth(Node p) {
        Node current = p;
        int result = 0;
        while (current != null) {
            current = current.parent;
            result++;
        }
        return result;
    }
}
