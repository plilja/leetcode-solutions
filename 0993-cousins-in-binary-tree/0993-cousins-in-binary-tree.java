/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        Map<Integer, Integer> parent = new HashMap<>();
        Map<Integer, Integer> depth = new HashMap<>();
        depth.put(root.val, 0);
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            int d = depth.get(n.val);
            if (n.left != null) {
                q.add(n.left);
                depth.put(n.left.val, d + 1);
                parent.put(n.left.val, n.val);
            }
            if (n.right != null) {
                q.add(n.right);
                depth.put(n.right.val, d + 1);
                parent.put(n.right.val, n.val);
            }
        }
        return depth.get(x) == depth.get(y) && parent.get(x) != parent.get(y) && x != y;
    }
}
