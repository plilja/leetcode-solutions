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
    public boolean isBalanced(TreeNode root) {
        return isBalancedHelper(root).balanced;
    }
    
    private TreeInfo isBalancedHelper(TreeNode node) {
        if (node == null) {
            return new TreeInfo(true, 0);
        } else {
            TreeInfo left = isBalancedHelper(node.left);
            TreeInfo right = isBalancedHelper(node.right);
            boolean isBalanced = left.balanced && 
                                 right.balanced && 
                                 Math.abs(left.height() - right.height) <= 1;
            return new TreeInfo(isBalanced, 1 + Math.max(left.height, right.height));
        }
    }
    
    private record TreeInfo(boolean balanced, int height) {}
}
