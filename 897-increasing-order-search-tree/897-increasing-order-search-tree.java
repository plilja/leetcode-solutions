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
    public TreeNode increasingBST(TreeNode root) {
        return increasingBSTHelper(root).left();
    }
    
    private Pair<TreeNode, TreeNode> increasingBSTHelper(TreeNode node) {
        if (node.left == null && node.right == null) {
            // leaf
            return new Pair(node, node);
        } else {
            TreeNode leftTmp = node.left;
            TreeNode rightTmp = node.right;
            TreeNode min = node;
            TreeNode max = node;
            if (leftTmp != null) {
                Pair<TreeNode, TreeNode> sub = increasingBSTHelper(leftTmp);
                min = sub.left();
                sub.right().right = node;
            }
            if (rightTmp != null) {
                Pair<TreeNode, TreeNode> sub = increasingBSTHelper(rightTmp);
                max.right = sub.left();
                max = sub.right();
            }
            node.left = null;
            return new Pair(min, max);
        }
    }
    
    
    private record Pair<A, B>(A left, B right) {
        
    }
}