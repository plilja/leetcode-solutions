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
    public TreeNode bstToGst(TreeNode root) {
        return bstToGstHelper(root, new AtomicInteger());
    }
    
    private TreeNode bstToGstHelper(TreeNode node, AtomicInteger sum) {
        if (node == null) {
            return null;
        } else {
            TreeNode right = bstToGstHelper(node.right, sum);
            sum.set(sum.get() + node.val);
            TreeNode result = new TreeNode(sum.get());
            TreeNode left = bstToGstHelper(node.left, sum);
            result.left = left;
            result.right = right;
            return result;
        }
    }
}