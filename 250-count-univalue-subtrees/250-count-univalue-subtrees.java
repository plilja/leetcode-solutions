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
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        AtomicInteger result = new AtomicInteger(0);
        countUnivalSubtreesHelper(root, root.val, result);
        return result.get();
    }
    
    private boolean countUnivalSubtreesHelper(TreeNode node, int val, AtomicInteger result) {
        if (node == null) {
            return true;
        }
        boolean left = countUnivalSubtreesHelper(node.left, node.val, result);
        boolean right = countUnivalSubtreesHelper(node.right, node.val, result);
        if (left && right) {
            result.getAndIncrement();
        }
        return node.val == val && left && right;
    }
}
