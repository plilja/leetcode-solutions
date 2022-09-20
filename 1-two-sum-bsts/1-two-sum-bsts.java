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
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        TreeNode current = root1;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root1);
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            int rem = target - n.val;
            if (containsValue(root2, rem)) {
                return true;
            }
            if (n.left != null) {
                q.add(n.left);
            }
            if (n.right != null) {
                q.add(n.right);
            }
        }
        return false;
    }
    
    private boolean containsValue(TreeNode node, int target) {
        if (node == null) {
            return false;
        } else if (target < node.val) {
            return containsValue(node.left, target);
        } else if (target == node.val) {
            return true;
        } else {
            return containsValue(node.right, target);
        }
    }
}
