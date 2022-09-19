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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        TreeNode result = new TreeNode(0);
        if (root1 != null) {
            result.val += root1.val;
        }
        if (root2 != null) {
            result.val += root2.val;
        }
        if (left(root1) != null || left(root2) != null) {
            result.left = mergeTrees(left(root1), left(root2));
        }
        if (right(root1) != null || right(root2) != null) {
            result.right = mergeTrees(right(root1), right(root2));
        }
        return result;
    }
    
    private TreeNode left(TreeNode node) {
        if (node == null) {
            return null;
        } else {
            return node.left;
        }
    }
    
    private TreeNode right(TreeNode node) {
        if (node == null) {
            return null;
        } else {
            return node.right;
        }
    }
}
