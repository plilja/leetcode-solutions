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
    public int maxPathSum(TreeNode root) {
        AtomicInteger result = new AtomicInteger(Integer.MIN_VALUE);
        solve(root, result);
        return result.get();
    }
    
    private int solve(TreeNode node, AtomicInteger result) {
        if (node == null) {
            return 0;
        }
        int left = solve(node.left, result);
        int right = solve(node.right, result);
        if (result.get() < left + right + node.val) {
            result.set(left + right + node.val);
        }
        if (result.get() < left + node.val) {
            result.set(left + node.val);
        }
        if (result.get() < right + node.val) {
            result.set(right + node.val);
        }
        if (result.get() < node.val) {
            result.set(node.val);
        }
        return Math.max(Math.max(node.val, node.val + left), node.val + right);
    }
}
