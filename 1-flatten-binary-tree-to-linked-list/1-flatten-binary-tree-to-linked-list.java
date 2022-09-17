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
    public void flatten(TreeNode root) {
        if (root != null) {
            flattenHelper(root);
        }
    }
    
    private Pair flattenHelper(TreeNode node) {
        if (isLeaf(node)) {
            return new Pair(node, node);
        } 
        TreeNode last = node;
        TreeNode leftTmp = node.left;
        TreeNode rightTmp = node.right;
        node.left = null;
        node.right = null;
        if (leftTmp != null) {
            Pair p = flattenHelper(leftTmp);
            last.right = p.left;
            last = p.right;
        }
        if (rightTmp != null) {
            Pair p = flattenHelper(rightTmp);
            last.right = p.left;
            last = p.right;
        }
        return new Pair(node, last);
    }
    
    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
    
    private record Pair(TreeNode left, TreeNode right) {
    }
}
