/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        return helper(root).head;
    }
    
    private HeadLast helper(Node node) {
        boolean isLeaf = node.left == null && node.right == null;
        if (isLeaf) {
            node.left = node;
            node.right = node;
            return new HeadLast(node, node);
        } else {
            HeadLast result = new HeadLast(node, node);
            HeadLast left = null;
            HeadLast right = null;
            if (node.left != null) {
                left = helper(node.left);
            }
            if (node.right != null) {
                right = helper(node.right);
            }
            if (left != null) {
                result = concat(left, result);
            }
            if (right != null) {
                result = concat(result, right);
            }
            return result;
        }
    }
    
    private HeadLast concat(HeadLast start, HeadLast end) {
        start.head.left = end.last;
        end.last.right = start.head;
        
        start.last.right = end.head;
        end.head.left = start.last;
        
        return new HeadLast(start.head, end.last);
    }
    
    private record HeadLast(Node head, Node last) {
    }
}