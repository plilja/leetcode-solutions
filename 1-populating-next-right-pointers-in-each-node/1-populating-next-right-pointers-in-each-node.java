/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Deque<Node> q = new ArrayDeque<>();
        Map<Node, Integer> depths = new HashMap<>();
        q.add(root);
        depths.put(root, 0);
        Map<Integer, Node> depthToLast = new HashMap<>();
        while (!q.isEmpty()) {
            Node node = q.poll();
            int depth = depths.get(node);
            Node last = depthToLast.get(depth);
            node.next = last;
            depthToLast.put(depth, node);
            if (node.right != null) {
                depths.put(node.right, depth + 1);
                q.add(node.right);
            }
            if (node.left != null) {
                depths.put(node.left, depth + 1);
                q.add(node.left);
            }
        }
        return root;
    }
}
