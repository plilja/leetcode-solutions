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
    public boolean findTarget(TreeNode root, int k) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            int rem = k - node.val;
            if (contains(root, node, rem)) {
                return true;
            }
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
        return false;
    }
    
    private boolean contains(TreeNode root, TreeNode node, int value) {
        if (root == null) {
            return false;
        } else if (root.val > value) {
            return contains(root.left, node, value);
        } else if (root.val == value && root != node) {
            return true;
        } else {
            return contains(root.right, node, value);
        }
    }
}