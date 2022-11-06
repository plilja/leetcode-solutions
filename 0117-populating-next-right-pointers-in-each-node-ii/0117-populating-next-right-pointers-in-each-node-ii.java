class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Deque<Node> q1 = new ArrayDeque<>();
        Deque<Integer> q2 = new ArrayDeque<>();
        q1.add(root);
        q2.add(1);
        int prevLevel = -1;
        Node prev = null;
        while (!q1.isEmpty()) {
            Node n = q1.poll();
            int level = q2.poll();
            if (prevLevel == level) {
                n.next = prev;
            }
            if (n.right != null) {
                q1.add(n.right);
                q2.add(level + 1);
            }
            if (n.left != null) {
                q1.add(n.left);
                q2.add(level + 1);
            }
            prev = n;
            prevLevel = level;
        }
        return root;
    }
}