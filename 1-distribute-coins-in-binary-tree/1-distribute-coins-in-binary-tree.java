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
    record Balance(int balance, int costToMove) {}
    
    public int distributeCoins(TreeNode root) {
        var result = dfs(root);
        return result.costToMove();
    }
    
    private Balance dfs(TreeNode node) {
        if (node == null) {
            return new Balance(0, 0);
        } else {
            Balance subLeft = dfs(node.left);
            Balance subRight = dfs(node.right);
            int newBalance = subLeft.balance() + subRight.balance() + node.val - 1;
            int costToMove = subLeft.costToMove() + subRight.costToMove() + Math.abs(newBalance);
            return new Balance(newBalance, costToMove);
        }
    }
}
