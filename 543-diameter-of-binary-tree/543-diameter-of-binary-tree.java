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
    public int diameterOfBinaryTree(TreeNode root) {
        AtomicInteger result = new AtomicInteger(0);
        helper(root, result);
        return result.get();
    }
    
    public int helper(TreeNode root, AtomicInteger result) {
        int leftFinger = 0;
        if (root.left != null) {
            leftFinger = helper(root.left, result) + 1;
        }
        int rightFinger = 0;
        if (root.right != null) {
            rightFinger = helper(root.right, result) + 1;
        }
        if (result.get() < leftFinger + rightFinger) {
            result.set(leftFinger + rightFinger);
        }
        return Math.max(leftFinger, rightFinger);
    }
}