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
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeavesHelper(root.left, true) + sumOfLeftLeavesHelper(root.right, false);
        
    }
    
    private int sumOfLeftLeavesHelper(TreeNode node, boolean cameFromRight) {
        if (node == null) {
            return 0;
        } else if (isLeaf(node)) {
            return cameFromRight ? node.val : 0;
        } else {
            return sumOfLeftLeavesHelper(node.left, true) + sumOfLeftLeavesHelper(node.right, false);
        }
    }
    
    
    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
}
