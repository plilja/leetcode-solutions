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
    public String tree2str(TreeNode root) {
        StringBuilder result = new StringBuilder();
        helper(root, result);
        return result.toString();
    }
    
    private void helper(TreeNode node, StringBuilder result) {
        result.append(node.val);
        if (node.left != null || node.right != null) {
            if (node.left != null) {
                result.append('(');
                helper(node.left, result);
                result.append(')');
            } else {
                result.append("()");
            }
            if (node.right != null) {
                result.append('(');
                helper(node.right, result);
                result.append(')');
            }
        }
    }
}