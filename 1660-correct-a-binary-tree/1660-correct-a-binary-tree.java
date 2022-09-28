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
    public TreeNode correctBinaryTree(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            if (parents.containsKey(n.right)) {
                // found the invalid node
                var parent = parents.get(n);
                if (parent.left == n) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
                break;
            }
            if (n.left != null) {
                parents.put(n.left, n);
                q.add(n.left);
            }
            if (n.right != null) {
                parents.put(n.right, n);
                q.add(n.right);
            }
        }
        return root;
    }
}