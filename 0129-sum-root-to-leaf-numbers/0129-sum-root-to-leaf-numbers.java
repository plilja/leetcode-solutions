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
    public int sumNumbers(TreeNode root) {
        AtomicInteger sum = new AtomicInteger(0);
        dfs(root, new StringBuilder(), sum);
        return sum.get();
    }
    
    private void dfs(TreeNode node, StringBuilder current, AtomicInteger sum) {
        current.append(String.valueOf(node.val));
        if (node.left == null && node.right == null) {
            // leaf
            sum.set(sum.get() + Integer.parseInt(current.toString()));
        } else {
            if (node.left != null) {
                dfs(node.left, current, sum);
            }
            if (node.right != null) {
                dfs(node.right, current, sum);
            }
        }
        current.deleteCharAt(current.length() - 1);
    }
}